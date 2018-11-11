package com.pyg.search.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.pyg.pojo.TbItem;
import com.pyg.search.service.ItemSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.data.domain.Sort;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.Criteria;
import org.springframework.data.solr.core.query.HighlightOptions;
import org.springframework.data.solr.core.query.SimpleFilterQuery;
import org.springframework.data.solr.core.query.SimpleHighlightQuery;
import org.springframework.data.solr.core.query.result.HighlightPage;
import org.springframework.data.solr.core.query.result.HighlightEntry.Highlight;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ItemSearchServiceImpl implements ItemSearchService {

    // yws:这里不是reference,solrtemple的bean已经引进来了
    //直接autowried就可以了.
    @Autowired
    private SolrTemplate solrTemplate;

    @Override
    public Map search(Map searchMap) {

        // yws:告诉solr那些域对象的内容是高亮显示的
        // yws:设置高亮选项
        HighlightOptions highlightOptions = new HighlightOptions();

        // yws:通过addfield方法告诉solr item_title域是高亮的
        highlightOptions.addField("item_title");

        // yws:其实到底是咋设置高亮的呢,其实就是再查询的结果字符串前后拼个红色的样式
        highlightOptions.setSimplePrefix("<em style='color:red'>");
        highlightOptions.setSimplePostfix("</em>");

        // yws:注意我们只是对上面搜索栏输入的内容增加高亮 获得输入栏的内容
        String keywords = (String) searchMap.get("keywords");

        // yws:现在我们拼接了高亮查询的query对象,里面封装了查询的条件
        // 正常我们就是调用solrtempt(query)去查询就好了
        //注意他再调querypage的时候是会自动分词的.
        SimpleHighlightQuery simpleHighlightQuery = new SimpleHighlightQuery();
        Criteria criteria = new Criteria("item_keywords");
        criteria = criteria.is(keywords);
        // yws:增加这个query对象的条件和高亮规格
        simpleHighlightQuery.addCriteria(criteria);
        simpleHighlightQuery.setHighlightOptions(highlightOptions);

        // yws:但是现在呢,我们不仅有上面的搜索栏的内容,下面用户 还可以选品牌啊
        //选价格啊,规格啊啥的,所以我们就要搞很多过滤条件
        //所以你现在这个highlightquery以后会吞很多小的query,这些小query就是封装的
        //其他的过滤条件
        String categoryStr = (String) searchMap.get("category");
        //通过Criteria拼接category条件
        if (categoryStr != null && categoryStr.length() > 0) {

            // yws:注意这个query一会是会被添加到大的高亮query对象里面去的
            SimpleFilterQuery simpleFilterQuery = new SimpleFilterQuery();
            // yws:注意再创建criteral对象的时候要传进去域名
            Criteria filterCriteria = new Criteria("item_category");
            filterCriteria = filterCriteria.is("categoryStr");
            simpleFilterQuery.addCriteria(filterCriteria);
            // yws:通过addfilter方法把filterquery添加到大的query对象里面
            simpleHighlightQuery.addFilterQuery(simpleFilterQuery);
        }

        //=============拼接品牌条件=============
        String brandStr = (String) searchMap.get("brand");
        if (brandStr != null && brandStr.length() > 0) {
            System.out.println("====分类名称===" + brandStr);
            Criteria filterCriteria = new Criteria("item_brand");
            filterCriteria = filterCriteria.is(brandStr);  //封装品牌条件查询
            SimpleFilterQuery filterQuery = new SimpleFilterQuery(filterCriteria);
            simpleHighlightQuery.addFilterQuery(filterQuery);  //增加过滤条件
        }

        //拼接规格条件
        // yws:由于规格有多个,所以我们遍历每个规格,往里面加多个query
        Map<String, String> specMap = (Map<String, String>) searchMap.get("spec");
        for (String key : specMap.keySet()) {
            String specName = specMap.get(key);
            Criteria filterCriteria = new Criteria("item_spec_" + key);  //循环所有的map用key当查询条件
            filterCriteria = filterCriteria.is(specName);     //匹配map中value的值
            SimpleFilterQuery filterQuery = new SimpleFilterQuery(filterCriteria);
            simpleHighlightQuery.addFilterQuery(filterQuery);  //增加过滤条件
        }

        //按照价格的范围查询
        String priceStr = (String) searchMap.get("price");
        if (priceStr != null && priceStr.length() > 0) {
            String[] price = priceStr.split("-");

            if (!"0".equals(price[0])) { //拿起始价格 ,如果不等于0 应该是大于等于 起始价格
                Criteria filterCriteria = new Criteria("item_price"); //参数填域名
                filterCriteria = filterCriteria.greaterThanEqual(price[0]);  //封装品牌条件查询
                SimpleFilterQuery filterQuery = new SimpleFilterQuery(filterCriteria);
                simpleHighlightQuery.addFilterQuery(filterQuery);  //增加过滤条件
            }

            if (!"*".equals(price[1])) { //拿结束价格 ,如果不等于* 应该是小于等于 结束价格
                Criteria filterCriteria = new Criteria("item_price"); //参数填域名
                filterCriteria = filterCriteria.lessThanEqual(price[1]);  //封装品牌条件查询
                SimpleFilterQuery filterQuery = new SimpleFilterQuery(filterCriteria);
                simpleHighlightQuery.addFilterQuery(filterQuery);  //增加过滤条件
            }
        }

        // yws:上面已经写好按照价格范围查询了,但是升序显示还是倒叙显示要设置下
        //所以我们给highlightquery对象add一个sort的对象.
        String orderStr = (String) searchMap.get("sort");
        if ("ASC".equals(orderStr)) { //按照价格进行升序查询
            Sort sort = new Sort(Sort.Direction.ASC, "item_price");
            simpleHighlightQuery.addSort(sort);
        } else {  //反之是降序查询
            Sort sort = new Sort(Sort.Direction.DESC, "item_price");
            simpleHighlightQuery.addSort(sort);
        }

        // yws:注意这个solr的分页的数据是要自己写的哦,没有分页工具哦,这个solr不是查mysql
        //设置当前页和每页大小
        Integer pageNo = (Integer) searchMap.get("page");
        Integer pageSize = (Integer) searchMap.get("pageSize");

        // yws:这些分页信息都是要塞到highlightquery对象里面去的
        //你看看highlight对象塞了多少查询信息,

        // yws:塞了高亮规格,一阵过滤的filterquery,和sort是按照那种顺序查询,
        //到后来还塞了分页的信息.
        simpleHighlightQuery.setOffset((pageNo - 1) * pageSize);   //起始记录数
        simpleHighlightQuery.setRows(pageSize);   //每页记录数


        // yws:这里调用queryforhighlightpage方法 第二个参数是TbItem.class
        HighlightPage<TbItem> page = solrTemplate.queryForHighlightPage(simpleHighlightQuery, TbItem.class); //template采用高亮查询


        // yws:注意内容是再getcontent里获取的.
        List<TbItem> itemList = page.getContent();



        // yws:查询出来了一个个的Tbitem对象.

        // yws:虽然我们上面设置了很多的高亮的东西,
        //但是查询出来的还是不是高亮的,所以我们要再遍历itemlist,
        //给list种的每个item都添加高亮的东西.....
        //因为我们只有一个高亮的titile.所以这里都是get(0)
        for (TbItem tbItem : itemList) {
            List<Highlight> highlights = page.getHighlights(tbItem);
            if (highlights.size() > 0 && highlights.get(0).getSnipplets().size() > 0 && keywords.length() > 0) {

                Highlight highlight = highlights.get(0);
                String highlightTitle = highlight.getSnipplets().get(0);
                System.out.println("===高亮后的内容===" + highlightTitle);

                tbItem.setTitle(highlightTitle);//solr将高亮的数据封装到该集合中
            }
        }


        // yws:把查询出来的数据封装到rows和total这种分页的结构里面
        HashMap returnMap = new HashMap();
        returnMap.put("rows", page.getContent());
        returnMap.put("total", page.getTotalElements()); //获取总记录数
        return returnMap;
    }
}
