package com.pyg.search.service.impl;

import com.pyg.pojo.TbItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.Criteria;
import org.springframework.data.solr.core.query.SimpleQuery;
import org.springframework.data.solr.core.query.result.ScoredPage;

import java.util.List;
import java.util.Map;

public class SolrTest {


    //这是一种比较简单的solrtemplate query critail page.getcontent的关系.




    // yws:这个solr的查询是这么玩的,先有一个solrtemplte对象
    @Autowired
    private SolrTemplate solrTemplate;

    public List<TbItem> search(Map searchMap) {
        // TODO Auto-generated method stub
        String keywords = (String) searchMap.get("keywords");
        System.out.println("====搜索关键字==="+keywords);


        // yws:第二步就是搞除一个query对象,这个对象就是用来往里面添加条件的
        SimpleQuery query = new SimpleQuery("*:*");

        // yws:创建条件对象,这个条件对象的构造参数就是这个条件对应的是哪个域
        Criteria criteria = new Criteria("item_keywords");

        // yws:用这种c=c.xxx的方式确定这个域中值是什么限制
        criteria = criteria.is(keywords);

        // yws:把条件添加到query对象里
        query.addCriteria(criteria);

        // yws:注意这个查询是用solrtemplate对象去调用queryforpage方法 第一个参数是query.
        ScoredPage<TbItem> page = solrTemplate.queryForPage(query, TbItem.class);
        System.out.println("======NumberOfElements"+page.getNumberOfElements());
        System.out.println("======size"+page.getSize());
        System.out.println("======number"+page.getNumber());

        // yws:注意真正的内容是在page的getcontent里面呢
        return page.getContent();
    }

}
