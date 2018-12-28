package com.stt.controller;

import com.stt.model.Brand;
import com.stt.service.BrandService;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/brand") //restful风格的一般都会有这个东西,表示资源 加/
public class BrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping("/count")
    public Result count(){
        int count = brandService.count();
        Result result = new Result();
        result.setCode(200);
        result.setFlag(true);
        result.setMessage("没问题");
        result.setData(count);

        return result;
    }

    @GetMapping  //这种查询全部的就啥也不用写了
    public Result findAllBrand(){
        List<Brand> brands = brandService.findAllBrand();

        Result result = new Result();
        result.setCode(200);
        result.setFlag(true);
        result.setMessage("没问题");
        result.setData(brands);

        return result;

    }



}
