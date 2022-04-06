package com.example.malladmin.service;

import com.example.malladmin.dto.PmsProductAttributeParam;
import com.example.mallmbg.model.PmsProductAttribute;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PmsProductAttributeService {
    /*分页获取商品属性*/
    List<PmsProductAttribute> getList(Long cid, Integer type, Integer pageNum, Integer pageSize);

    @Transactional
    int create(PmsProductAttributeParam pmsProductAttributeParam);
}
