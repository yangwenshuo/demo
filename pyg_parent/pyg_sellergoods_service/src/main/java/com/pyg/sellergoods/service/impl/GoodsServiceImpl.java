package com.pyg.sellergoods.service.impl;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.pyg.entity.Goods;
import com.pyg.entity.PageResult;
import com.pyg.mapper.*;
import com.pyg.pojo.*;
import com.pyg.sellergoods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;


/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	private TbGoodsMapper goodsMapper;
	
	@Autowired
	private TbGoodsDescMapper goodsDescMapper;
	
	@Autowired
	private TbItemMapper itemMapper;
	
	@Autowired
	private TbBrandMapper brandMapper;
	
	@Autowired
	private TbItemCatMapper itemCatMapper;
	
	@Autowired
	private TbSellerMapper sellerMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<TbGoods> findAll() {
		return goodsMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<TbGoods> page=   (Page<TbGoods>) goodsMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(Goods goods) {
		//新增spu
		TbGoods gs = goods.getGoods();
		//设置默认商品状态
		gs.setAuditStatus("0"); //0是未审核  //1是已审核  
		
		goodsMapper.insert(gs);	
		//新增spu的详情goodsDesc，一对一的关系需要设置
		TbGoodsDesc goodsDesc = goods.getGoodsDesc();
		goodsDesc.setGoodsId(gs.getId());
		goodsDescMapper.insert(goodsDesc);
		
		/*{spec : {IPHONE手机  网络移动3G 机身内存16G},price : 0,num : 99999,status : '0',isDefault : '0'} */
		if("1".equals(gs.getIsEnableSpec())){ //有itemList
			//处理sku列表信息
			List<TbItem> itemList = goods.getItemList();
			for (TbItem item : itemList) {
				
				String titleName = gs.getGoodsName();//商品名称转成sku的名称
				Map<String,String> specMap = JSON.parseObject(item.getSpec(), Map.class) ;
				for (String key : specMap.keySet()) {
					titleName += " "+ key + specMap.get(key);
				}
	   
				item.setTitle(titleName); 
				setItemValue(item,goods);
				itemMapper.insert(item);
			}
		}else{ //没有itemList需要手动创建一个tbItem
			TbItem item = new TbItem();
			
			//相当于页面初始值
			item.setStatus("1"); 
			item.setPrice(gs.getPrice()); //用gs的价格
			item.setIsDefault("1"); //默认商品
			item.setNum(9999);
			
			item.setTitle(gs.getGoodsName()); //sku的title直接是商品的名称
			setItemValue(item,goods);
			
			itemMapper.insert(item);
		}
		
		
	
	}
	
	public void setItemValue(TbItem item,Goods goods){
		TbGoods gs = goods.getGoods();
		TbGoodsDesc goodsDesc = goods.getGoodsDesc();
		
		TbBrand brand = brandMapper.selectByPrimaryKey(gs.getBrandId());
		item.setBrand(brand.getName()); //品牌名称
		
		
		TbItemCat itemCat = itemCatMapper.selectByPrimaryKey(gs.getCategory3Id()); //查询分类对象
		item.setCategory(itemCat.getName()); //分类名称
		item.setCategoryid(gs.getCategory3Id()); //分类id
		item.setCreateTime(new Date());  //创建时间
		item.setGoodsId(gs.getId());
		
		//将商品详情中第一张图片赋值给item
		List<Map> itemImages = JSON.parseArray(goodsDesc.getItemImages(), Map.class);
		if(itemImages.size() > 0){
			item.setImage(itemImages.get(0).get("url").toString());
		}
		
		TbSeller seller = sellerMapper.selectByPrimaryKey(gs.getSellerId());
		item.setSeller(seller.getName()); //设置商家名称
		item.setSellerId(gs.getSellerId());
		item.setSellPoint(gs.getCaption()); //副标题
		
		item.setUpdateTime(new Date()); //数据库不予许修改时间为空
	}
	
	/**
	 * 修改
	 */
	@Override
	public void update(Goods goods){
		//goodsMapper.updateByPrimaryKey(goods);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public Goods findOne(Long id){
		Goods goods=new Goods();
		TbGoods tbGoods = goodsMapper.selectByPrimaryKey(id);
		goods.setGoods(tbGoods);
		
		TbGoodsDesc tbGoodsDesc = goodsDescMapper.selectByPrimaryKey(id);
		goods.setGoodsDesc(tbGoodsDesc);
		
		//在public Goods findOne(Long id) 方法中增加，加载sku信息的内容
		TbItemExample example = new TbItemExample();
		com.pyg.pojo.TbItemExample.Criteria criteria = example.createCriteria();
		criteria.andGoodsIdEqualTo(id);// 查询条件： 商品 ID
		List<TbItem> itemList = itemMapper.selectByExample(example);
		goods.setItemList(itemList);
		
		return goods;
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Long[] ids) {
		for(Long id:ids){
			//goodsMapper.deleteByPrimaryKey(id); 真删改逻辑删除
			TbGoods goods = goodsMapper.selectByPrimaryKey(id);
			goods.setIsDelete("1");
			goodsMapper.updateByPrimaryKey(goods);
		}		
	}
	
	
		@Override
	public PageResult findPage(TbGoods goods, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TbGoodsExample example=new TbGoodsExample();
		TbGoodsExample.Criteria criteria = example.createCriteria();
		criteria.andIsDeleteIsNull(); //删除字段没有赋值的时候
		
		if(goods!=null){			
						if(goods.getSellerId()!=null && goods.getSellerId().length()>0){
				criteria.andSellerIdLike("%"+goods.getSellerId()+"%");
			}
			if(goods.getGoodsName()!=null && goods.getGoodsName().length()>0){
				criteria.andGoodsNameLike("%"+goods.getGoodsName()+"%");
			}
			if(goods.getAuditStatus()!=null && goods.getAuditStatus().length()>0){
				criteria.andAuditStatusLike("%"+goods.getAuditStatus()+"%");
			}
			if(goods.getIsMarketable()!=null && goods.getIsMarketable().length()>0){
				criteria.andIsMarketableLike("%"+goods.getIsMarketable()+"%");
			}
			if(goods.getCaption()!=null && goods.getCaption().length()>0){
				criteria.andCaptionLike("%"+goods.getCaption()+"%");
			}
			if(goods.getSmallPic()!=null && goods.getSmallPic().length()>0){
				criteria.andSmallPicLike("%"+goods.getSmallPic()+"%");
			}
			if(goods.getIsEnableSpec()!=null && goods.getIsEnableSpec().length()>0){
				criteria.andIsEnableSpecLike("%"+goods.getIsEnableSpec()+"%");
			}
			if(goods.getIsDelete()!=null && goods.getIsDelete().length()>0){
				criteria.andIsDeleteLike("%"+goods.getIsDelete()+"%");
			}
	
		}
		
		Page<TbGoods> page= (Page<TbGoods>)goodsMapper.selectByExample(example);		
		return new PageResult(page.getTotal(), page.getResult());
	}

		@Override
		public void updateStatus(Long[] ids, String status) {
			// TODO Auto-generated method stub
			for (Long id : ids) {
				TbGoods goods = goodsMapper.selectByPrimaryKey(id);
				goods.setAuditStatus(status);
				goodsMapper.updateByPrimaryKey(goods);
			}
		}
	
}
