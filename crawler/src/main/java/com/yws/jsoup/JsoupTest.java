package com.yws.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.File;
import java.net.URL;

public class JsoupTest {
    @Test
    public void testJsoup() throws Exception {
        //创建一个document对象
        //使用jsoup访问一个互联网的url
        Document document = Jsoup.parse(new URL("http://www.itcast.cn"), 1000);
        //对页面内容进行解析
        Elements title = document.getElementsByTag("title");
        System.out.println(title);
        //打印解析的结果
        for (Element element : title) {
            String text = element.text();
            System.out.println(text);
        }

    }

    @Test
    public void testJsoupLocal() throws Exception {
        //解析本地文件
        Document document = Jsoup.parse(new File("D:\\temp\\sy53\\hello.html"), "utf-8");
        //节点的选取
        //根据id选择节点
        Element element1 = document.getElementById("city_bj");
        System.out.println(element1.toString());
        //取标签内部的文本信息
        System.out.println(element1.text());
        //根据属性选择节点
        Elements elements = document.getElementsByAttribute("abc");
        System.out.println(elements);
        System.out.println(elements.text());
        //根据属性的值进行选择
        Elements classElements = document.getElementsByAttributeValue("class", "s_name");
        System.out.println(classElements);
        //根据css选择
        Elements element2 = document.select("#city_bj");
        System.out.println(element2);
        //根据class选择
        Elements elements3 = document.select(".s_name");
        System.out.println("----------------");
        System.out.println(elements3);

    }
}

