package com.pyg.sellergoods.service;
import com.pyg.entity.Goods;
import com.pyg.entity.PageResult;
import com.pyg.pojo.TbGoods;

import java.util.List;
import java.util.Map;


/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface GoodsService {

	/**
	 * 返回全部列表
	 * @return
	 */
	public List<TbGoods> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	public PageResult findPage(int pageNum, int pageSize);
	
	
	/**
	 * 增加
	*/
	public void add(Goods goods);
	
	
	/**
	 * 修改
	 */
	public void update(Goods goods);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	public Goods findOne(Long id);
	
	
	/**
	 * 批量删除
	 * @param ids
	 */
	public void delete(Long[] ids);

	/**
	 * 分页
	 * @param pageNum 当前页 码
	 * @param pageSize 每页记录数
	 * @return
	 */
	public PageResult findPage(TbGoods goods, int pageNum, int pageSize);
	
	/**
	 * 根据传入的商品id集合统一修改状态，完成运营商的审核
	 * @param ids
	 * @param status
	 */
	public void updateStatus(Long[] ids, String status);
}
