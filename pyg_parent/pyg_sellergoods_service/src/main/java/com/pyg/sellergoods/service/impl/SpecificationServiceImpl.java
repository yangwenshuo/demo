package com.pyg.sellergoods.service.impl;
import java.util.List;
import java.util.Map;

import com.pyg.entity.PageResult;
import com.pyg.entity.Specification;
import com.pyg.mapper.TbSpecificationOptionMapper;
import com.pyg.pojo.TbSpecificationExample;
import com.pyg.pojo.TbSpecificationExample.Criteria;
import com.pyg.pojo.TbSpecificationOption;
import com.pyg.pojo.TbSpecificationOptionExample;
import com.pyg.sellergoods.service.SpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pyg.mapper.TbSpecificationMapper;
import com.pyg.pojo.TbSpecification;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class SpecificationServiceImpl implements SpecificationService {

	@Autowired
	private TbSpecificationMapper specificationMapper;

	//在这里要引入里面的optionmapper
	@Autowired
	private TbSpecificationOptionMapper specificationOptionMapper;
	/**
	 * 查询全部
	 */
	@Override
	public List<TbSpecification> findAll() {
		return specificationMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		Page<TbSpecification> page = (Page<TbSpecification>) specificationMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(Specification specification) {
		// 规格保存数据库
		TbSpecification spec = specification.getSpecification();

		//这里再插入spect的时候,要再配置文件里增加selectkey属性,获得
		//后当作option的逻辑外键
//		<selectKey resultType="java.lang.Long" order="AFTER" keyProperty="id">
//				select last_insert_id() as id
//    	</selectKey>


		specificationMapper.insert(spec);

		// 规格选项保存数据库
		List<TbSpecificationOption> optionList = specification.getSpecOptionList();
		for (TbSpecificationOption option : optionList) {
			//逻辑外键直接get就可以了

			//然后循环调用optionmapper的insert方法,挨个增加
			option.setSpecId(spec.getId());
			specificationOptionMapper.insert(option);
		}
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(Specification specification) {

		// 规格进行修改操作
		TbSpecification spec = specification.getSpecification();
		specificationMapper.updateByPrimaryKey(spec);

		// 删掉规格id一样的所有规格选项
		//对于option来说,先删除以前的,然后再增加新的
		TbSpecificationOptionExample example = new TbSpecificationOptionExample();
		example.createCriteria().andSpecIdEqualTo(spec.getId());
		specificationOptionMapper.deleteByExample(example);

		// 先删除后新增解决选项的变动
		// 规格选项保存数据库
		List<TbSpecificationOption> optionList = specification.getSpecOptionList();
		for (TbSpecificationOption option : optionList) {
			option.setSpecId(spec.getId());
			specificationOptionMapper.insert(option);
		}
	}
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public Specification findOne(Long id) {
		// 根据传入的规格获取规格对象
		Specification specification = new Specification();
		specification.setSpecification(specificationMapper.selectByPrimaryKey(id));

		//两次按id查询  查询出逻辑主外键关系的主表

		// 根据传入的规格id查出所有的规格选项集合
		TbSpecificationOptionExample example = new TbSpecificationOptionExample();
		example.createCriteria().andSpecIdEqualTo(id);
		List<TbSpecificationOption> options = specificationOptionMapper.selectByExample(example);
		specification.setSpecOptionList(options);

		return specification;
	}
	/**
	 * 批量删除
	 */
	@Override
	public void delete(Long[] ids) {
		for(Long id:ids){
			specificationMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
	@Override
	public PageResult findPage(TbSpecification specification, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TbSpecificationExample example=new TbSpecificationExample();
		Criteria criteria = example.createCriteria();
		
		if(specification!=null){			
						if(specification.getSpecName()!=null && specification.getSpecName().length()>0){
				criteria.andSpecNameLike("%"+specification.getSpecName()+"%");
			}
	
		}
		
		Page<TbSpecification> page= (Page<TbSpecification>)specificationMapper.selectByExample(example);
		return new PageResult(page.getTotal(), page.getResult());
	}

	@Override
	public List<Map> selectOptionList() {

		return specificationMapper.selectOptionList();
	}
}
