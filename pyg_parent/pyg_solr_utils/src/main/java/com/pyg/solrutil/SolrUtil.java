package com.pyg.solrutil;

import java.util.List;
import java.util.Map;

import com.pyg.pojo.TbItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.pyg.mapper.TbItemMapper;

@Component
public class SolrUtil {


	// yws:注意要注入solrtemple对象.
	@Autowired
	private SolrTemplate solrTemplate;
	
	@Autowired
	private TbItemMapper itemMapper;
	
	/**
	 * 导入数据库的所有TbItem数据
	 */
	public void importDBDate(){
		
		//根据mapper查询数据库获取list集合
		
		List<TbItem> itemList = itemMapper.selectByExample(null);
		
		//动态域赋值
		for (TbItem tbItem : itemList) {

			// yws:注意这里就是用的一个json工具将json字符串转成了map
			//类似于gson.
			 Map specMap = JSON.parseObject(tbItem.getSpec(),Map.class);
			 tbItem.setSpecMap(specMap);
		}

		// yws:注意这里是savebeans参数是一个list,主要要commit
		solrTemplate.saveBeans(itemList);
		solrTemplate.commit();
	}
	
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath*:spring/applicationContext*.xml");
		SolrUtil util = (SolrUtil) ac.getBean("solrUtil");
		util.importDBDate();
		System.out.println("=====导入完成====");
	}
	
}
