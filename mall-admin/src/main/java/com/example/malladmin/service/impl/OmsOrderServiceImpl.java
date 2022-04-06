package com.example.malladmin.service.impl;

import com.example.malladmin.dao.OmsOrderDao;
import com.example.malladmin.dto.OmsOrderDetail;
import com.example.malladmin.dto.OmsOrderQueryParam;
import com.example.malladmin.service.OmsOrderService;
import com.example.mallmbg.model.OmsOrder;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OmsOrderServiceImpl implements OmsOrderService {
    @Autowired
    private OmsOrderDao orderDao;

    @Override
    public List<OmsOrder> list(OmsOrderQueryParam omsOrderQueryParam, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return orderDao.getList(omsOrderQueryParam);
    }

    @Override
    public OmsOrderDetail detail(Long id) {
        return orderDao.getDetail(id);
    }
}
