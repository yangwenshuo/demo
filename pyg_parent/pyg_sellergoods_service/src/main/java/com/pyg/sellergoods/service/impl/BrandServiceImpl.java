package com.pyg.sellergoods.service.impl;

import java.util.List;
import java.util.Map;

import com.pyg.entity.PageResult;
import com.pyg.pojo.TbBrandExample;
import com.pyg.pojo.TbBrandExample.Criteria;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pyg.mapper.TbBrandMapper;
import com.pyg.pojo.TbBrand;

import com.pyg.sellergoods.service.BrandService;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 服务实现层
 *
 * @author AdministratorFfF
 */
@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private TbBrandMapper brandMapper;

    /**
     * 查询全部
     */
    @Override
    public List<TbBrand> findAll() {
        return brandMapper.selectByExample(null);
    }

    /**
     * 按分页查询
     */
    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        DefaultListableBeanFactory

        Page<TbBrand> page = (Page<TbBrand>) brandMapper.selectByExample(null);
        return new PageResult(page.getTotal(), page.getResult());
    }

    /**
     * 增加
     */
    @Override
    public void add(TbBrand brand) {
        brandMapper.insert(brand);
    }

    /**
     * 修改
     */
    @Override
    public void update(TbBrand brand) {
        brandMapper.updateByPrimaryKey(brand);
    }

    /**
     * 根据ID获取实体
     *
     * @param id
     * @return
     */
    @Override
    public TbBrand findOne(Long id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    /**
     * 批量删除
     */
    @Override
    public void delete(Long[] ids) {
        for (Long id : ids) {
            brandMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public PageResult findPage(TbBrand brand, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        //如果我们想用一些条件查询,而现成的函数又不行了,我们要要用
        //selectbyexample了,我们先创建一个TbExample对象,
        //然后再用这个selectbyexample对象创建Criteria对象,然后用这个criteria
        //对象添加条件,这样,tbexamle对象里面的critria对象就创建完毕了,
        //然后我们把创建好的tbexample对象扔到selectbyexample方法的参数里就行了
        TbBrandExample example = new TbBrandExample();
        Criteria criteria = example.createCriteria();

        if (brand != null) {
            if (brand.getName() != null && brand.getName().length() > 0) {
                criteria.andNameLike("%" + brand.getName() + "%");
            }
            if (brand.getFirstChar() != null && brand.getFirstChar().length() > 0) {
                criteria.andFirstCharLike("%" + brand.getFirstChar() + "%");
            }

        }

        Page<TbBrand> page = (Page<TbBrand>) brandMapper.selectByExample(example);
        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public List<Map> selectOptionList() {

        return brandMapper.selectOptionList();
    }

}
