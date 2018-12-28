package com.stt.controller;

import com.stt.model.User;
import com.stt.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class TestControlller {

    private Logger log = LoggerFactory.getLogger("TestController");


    @Autowired
    private UserService userService;

    //读取配置文件中的内容 这个和properties还是不一样的
    //@Value("${yangguo}")
    @Value("${yangguo.weapon}")   //yml是这样获取的
    private String weapon;



    @RequestMapping("/add")

    public String addUser(HttpServletResponse response){

        log.info("狂战士的武器是什么={}","青光震兽剑");

        User u = new User((byte)1,1,1,1,1l,true,11l,1.1f,"1","sd");
        //魔鬼数字是int  不能直接给Long Byte这种包装类型赋值,要先弄成对应的基本类型.
        userService.insert(u);

        userService.testAsyn();

        log.info(weapon);

        //response.setStatus(500);

        return "添加成功";
    }




}
