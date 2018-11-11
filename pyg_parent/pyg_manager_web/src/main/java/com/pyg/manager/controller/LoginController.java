package com.pyg.manager.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class LoginController {

    @RequestMapping("/name")
    public Map name(){

        //注意这里是holder
        String name = SecurityContextHolder.getContext().getAuthentication().
                getName();

        Map map = new HashMap();

        map.put("loginName",name);

        //虽然这里返回的是map 但是由于你配置了fastjson,你返回的东西
        //都会被他们搞成json
        return map;



    }
}
