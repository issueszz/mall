package com.example.malladmin.service;

import com.example.mallmbg.model.PmsBrand;

import java.util.List;

public interface PmsBrandService {
    /*分页获取商品品牌*/
    List<PmsBrand> getList(String keyword, Integer pageNum, Integer pageSize);
}
