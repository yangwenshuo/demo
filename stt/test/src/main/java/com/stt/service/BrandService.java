package com.stt.service;

import com.stt.model.Brand;

import java.util.List;

public interface BrandService {


    List<Brand> findAllBrand();

    int count();
}
