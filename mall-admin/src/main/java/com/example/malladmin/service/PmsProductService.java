package com.example.malladmin.service;

import com.example.malladmin.dto.PmsProductParam;
import com.example.malladmin.dto.PmsProductQueryParam;
import com.example.malladmin.dto.PmsProductResult;
import com.example.mallmbg.model.PmsProduct;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PmsProductService {
    /*分页查询商品*/
    List<PmsProduct> list(PmsProductQueryParam pmsProductQueryParam, Integer pageNum, Integer pageSize);

    /*创建商品*/
    /*添加事务*/
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
    int create(PmsProductParam pmsProductParam);

    /*批量删除*/
    int updateDeleteStatus(List<Long> ids, Integer deleteStatus);

    /*根据商品id获取商品信息并且在此基础上修改*/
    PmsProductResult getUpdateInfo(Long id);
}
