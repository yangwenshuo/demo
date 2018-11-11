package com.pyg.page.service.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.pyg.mapper.TbGoodsDescMapper;
import com.pyg.mapper.TbGoodsMapper;
import com.pyg.mapper.TbItemCatMapper;
import com.pyg.mapper.TbItemMapper;
import com.pyg.page.service.ItemPageService;
import com.pyg.pojo.TbGoods;
import com.pyg.pojo.TbGoodsDesc;
import com.pyg.pojo.TbItem;
import com.pyg.pojo.TbItemExample;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ItemPageServiceImpl implements ItemPageService{

    @Value("${pagedir}")
    private String pagedir;

    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;

    @Autowired
    private FreeMarkerConfigurer configurer;

    @Autowired
    private TbGoodsMapper goodsMapper;

    @Autowired
    private TbGoodsDescMapper goodsDescMapper;

    @Autowired
    private TbItemCatMapper itemCatMapper;

    @Autowired
    private TbItemMapper itemMapper;


    @Override
    public boolean createItemHtml(Long goodsId) {

        // yws:通过freemarkerconfiguer对象获取configuration对象
        Configuration configuration = freeMarkerConfigurer.getConfiguration();
        // yws:通过configuration对象获得template对象

        FileWriter fileWriter = null;

        try {
            Template template = configuration.getTemplate("item.ftl");

            // yws:我们的生成的html文件的名字是这样拼出来的.
            fileWriter = new FileWriter(pagedir + goodsId + ".html");

            Map modelMap = new HashMap();

            TbGoods goods = goodsMapper.selectByPrimaryKey(goodsId);
            TbGoodsDesc goodsDesc = goodsDescMapper.selectByPrimaryKey(goodsId);

            String itemCat1= itemCatMapper.selectByPrimaryKey(goods.getCategory1Id()).getName();
            String itemCat2= itemCatMapper.selectByPrimaryKey(goods.getCategory2Id()).getName();
            String itemCat3= itemCatMapper.selectByPrimaryKey(goods.getCategory3Id()).getName();

            modelMap.put("goods", goods);
            modelMap.put("goodsDesc", goodsDesc);
            modelMap.put("itemCat1", itemCat1);
            modelMap.put("itemCat2", itemCat2);
            modelMap.put("itemCat3", itemCat3);

            // yws:根据商品id查出他的所有的SKU,并根据SKU的是不是default排序
            //这样的话isdefaule=0,也就是默认的就会到第一位....
            TbItemExample example = new TbItemExample();
            example.createCriteria().andGoodsIdEqualTo(goodsId);
            example.setOrderByClause("is_default desc");
            List<TbItem> tbItemList = itemMapper.selectByExample(example);

            modelMap.put("itemList", tbItemList);

            template.process(modelMap,fileWriter);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean removeItemHtml(Long[] goodsId) {
        // TODO Auto-generated method stub
        try {
            for (Long gid : goodsId) {
                new File(pagedir+gid+".html").delete();
            }
            return true;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
    }
}
