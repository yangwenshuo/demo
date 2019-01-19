package com.stt;

import com.config.CatTest;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@MapperScan("com.stt.mapper")
//@EnableScheduling
@EnableAsync
@Import(CatTest.class)   //如果比较多的话可以统一弄一个appconfig
//那个config import很多,然后这个把那个import就可以了
//这歌improt一般都是用来弄配置的bean
public class SttApplication {

	//d待编写  restful代码测试
	//单元测试代码

	//那个视频没有看,swagger和拦截器的时候 webappconfig

	public static void main(String[] args) {
		SpringApplication.run(SttApplication.class, args);


	}

}

