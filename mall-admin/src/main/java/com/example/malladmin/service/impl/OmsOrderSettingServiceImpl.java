package com.example.malladmin.service.impl;

import com.example.malladmin.service.OmsOrderSettingService;
import com.example.mallmbg.mapper.OmsOrderSettingMapper;
import com.example.mallmbg.model.OmsOrderSetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OmsOrderSettingServiceImpl implements OmsOrderSettingService {
    @Autowired
    private OmsOrderSettingMapper settingMapper;

    @Override
    public OmsOrderSetting getItem(Long id) {
        return settingMapper.selectByPrimaryKey(id);
    }

    @Override
    public int update(Long id, OmsOrderSetting orderSetting) {
        orderSetting.setId(id);
        return settingMapper.updateByPrimaryKey(orderSetting);
    }
}
