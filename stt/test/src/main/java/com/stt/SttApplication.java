package com.stt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@MapperScan("com.stt.mapper")
//@EnableScheduling
@EnableAsync
public class SttApplication {

	//d待编写  restful代码测试
	//单元测试代码

	//那个视频没有看,swagger和拦截器的时候 webappconfig

	public static void main(String[] args) {
		SpringApplication.run(SttApplication.class, args);


	}

}

