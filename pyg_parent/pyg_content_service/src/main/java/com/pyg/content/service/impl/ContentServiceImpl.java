package com.pyg.content.service.impl;
import java.util.List;

import com.pyg.content.service.ContentService;
import com.pyg.entity.PageResult;
import com.pyg.mapper.TbContentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import com.pyg.pojo.TbContent;
import com.pyg.pojo.TbContentExample;
import com.pyg.pojo.TbContentExample.Criteria;




/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class ContentServiceImpl implements ContentService {

	@Autowired
	private TbContentMapper contentMapper;
	
	@Autowired
	private RedisTemplate redisTemplate;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<TbContent> findAll() {
		return contentMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<TbContent> page=   (Page<TbContent>) contentMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(TbContent content) {
		contentMapper.insert(content);	
		//redis数据同步逻辑
		redisTemplate.boundHashOps("content").delete(content.getCategoryId());
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(TbContent content){
		contentMapper.updateByPrimaryKey(content);
		//处理新分类有新的广告数据，旧分类还是存在广告数据
		TbContent dbContent = contentMapper.selectByPrimaryKey(content.getId());
		redisTemplate.boundHashOps("content").delete(dbContent.getCategoryId()); //删除旧的广告分类数据
		redisTemplate.boundHashOps("content").delete(content.getCategoryId());//并且删除新的广告分类数据
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public TbContent findOne(Long id){
		return contentMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Long[] ids) {
		for(Long id:ids){
			//根据传入的id获取数据库中的广告对象，进行删除，必须在删除广告对象前，进行分类缓存数据的清除
			TbContent dbContent = contentMapper.selectByPrimaryKey(id);
			redisTemplate.boundHashOps("content").delete(dbContent.getCategoryId());
			
			contentMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
	@Override
	public PageResult findPage(TbContent content, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TbContentExample example=new TbContentExample();
		Criteria criteria = example.createCriteria();
		
		if(content!=null){			
						if(content.getTitle()!=null && content.getTitle().length()>0){
				criteria.andTitleLike("%"+content.getTitle()+"%");
			}
			if(content.getUrl()!=null && content.getUrl().length()>0){
				criteria.andUrlLike("%"+content.getUrl()+"%");
			}
			if(content.getPic()!=null && content.getPic().length()>0){
				criteria.andPicLike("%"+content.getPic()+"%");
			}
			if(content.getStatus()!=null && content.getStatus().length()>0){
				criteria.andStatusLike("%"+content.getStatus()+"%");
			}
	
		}
		
		Page<TbContent> page= (Page<TbContent>)contentMapper.selectByExample(example);		
		return new PageResult(page.getTotal(), page.getResult());
	}

		@Override
		public List<TbContent> findByCategoryId(Long categoryId) {
			// TODO Auto-generated method stub
			// 先查询redis是否有广告数据
			List<TbContent> contentList = (List<TbContent>) redisTemplate.boundHashOps("content").get(categoryId);
			
			
			// 如果没有查询数据库，并且存入redis中
			if(contentList == null){
				TbContentExample example=new TbContentExample();
				example.createCriteria().andCategoryIdEqualTo(categoryId);
				contentList = contentMapper.selectByExample(example);


				//放入redis中
				redisTemplate.boundHashOps("content").put(categoryId, contentList);
				redisTemplate.opsForValue().setIfAbsent("sd","sd");


				System.out.println("===查询数据库===");
			}else{
				System.out.println("===查询redis===");
			}
			
			return contentList;
		}
	
}
