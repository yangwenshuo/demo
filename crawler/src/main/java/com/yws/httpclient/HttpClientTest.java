package com.yws.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HttpClientTest {

    //对于服务器来说，他是区别的不了是爬虫还是真的浏览器的

    //一般的请求都是get的，因为post只是在表单那里会用到，别的地方都用不到

    private static final Logger logger = LoggerFactory.getLogger(HttpClientTest.class);

    @Test
    public void testPoolingHttpClientManager() throws Exception {

        logger.info("我来了啊");

        //创建一个连接池对象。
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();


        //这里在使用httpclients我们的closeablehttpclient对象的时候，不要用
        //createdefault方法而是custom（）方法，然后设置链接池对象然后调用build方法。
        CloseableHttpClient httpClient = HttpClients.custom()
                .setConnectionManager(connectionManager)
                .build();


        //后面的就差不多了，创建请求对象，然后excute。

        HttpGet get = new HttpGet("http://www.itcast.cn");

        CloseableHttpResponse response = httpClient.execute(get);

        String html = EntityUtils.toString(response.getEntity(), "utf-8");
        System.out.println(html);

        response.close();

    }


    @Test
    public void httpGetTest() throws IOException {

        //通过httpclients的createdefault方法创建一个浏览器对象，client这个东西就是叫浏览器
        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();

        //这里的一个get请求封装的是一个对象   get请求想带参数就直接在url后面加就可以了
        HttpGet httpGet = new HttpGet("https://www.cnblogs.com/zhangpengshou/p/5366413.html");

        //通过浏览器对象的excute方法执行获得响应
        CloseableHttpResponse closeableHttpResponse = closeableHttpClient.execute(httpGet);

        //这样可以直接打印出响应首行
        System.out.println(closeableHttpResponse.getStatusLine());


        //通过getentity方法获得响应体
        HttpEntity entity = closeableHttpResponse.getEntity();

        //使用人家弄好的entityutil工具获取html里面的内容
        String html = EntityUtils.toString(entity,"utf-8");

        //转换成字符串后将html的东西给打印出来
        System.out.println(html);

        //关闭响应对象和浏览器对象
        closeableHttpResponse.close();
        closeableHttpClient.close();

    }


    //post请求和get请求差不多，都是先弄一个closeablehttpclient对象
    //然后创建httppost对象，然后用集合往httppost对象里塞属性
    //然后在excute就可以了

    @Test
    public void testHttpPostWithParam() throws Exception {
        //1）创建一个HttpClient对象，CloseableHttpClient。
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //2）创建一个HttpPost对象。指定一个请求的url。
        HttpPost post = new HttpPost("http://bbs.itheima.com/search.php");
        //2')发送请求之前，向创建一个表单数据，把向服务器发送的参数添加到表单中。
        List<NameValuePair> formList  = new ArrayList<>();
        //添加参数
        formList.add(new BasicNameValuePair("mod", "forum"));
        formList.add(new BasicNameValuePair("searchid", "4"));
        formList.add(new BasicNameValuePair("orderby", "lastpost"));
        formList.add(new BasicNameValuePair("ascdesc", "desc"));
        formList.add(new BasicNameValuePair("searchsubmit", "yes"));
        formList.add(new BasicNameValuePair("kw", "java"));
        HttpEntity entity = new UrlEncodedFormEntity(formList);
        //设置post参数
        post.setEntity(entity);
        //3）使用HttpClient发送post请求。
        CloseableHttpResponse response = httpClient.execute(post);
        //4）接收响应的结果
        String html = EntityUtils.toString(response.getEntity(), "utf-8");
        //5）打印结果
        System.out.println(html);
        //6）关闭流
        response.close();
        httpClient.close();
    }

}
