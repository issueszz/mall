package com.example.malladmin.service;

import com.example.mallmbg.model.OmsOrderSetting;

public interface OmsOrderSettingService {
    /*获取指定订单设置*/
    OmsOrderSetting getItem(Long id);

    /*修改指定订单设置*/
    int update(Long id, OmsOrderSetting orderSetting);
}
