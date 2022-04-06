package com.example.malladmin.service;

import com.example.malladmin.dto.OmsOrderDetail;
import com.example.malladmin.dto.OmsOrderQueryParam;
import com.example.mallmbg.model.OmsOrder;

import java.util.List;

public interface OmsOrderService {
    /*批量查询订单*/
    List<OmsOrder> list(OmsOrderQueryParam omsOrderQueryParam, Integer pageNum, Integer pageSize);
    /*订单详情*/
    OmsOrderDetail detail(Long id);
}
