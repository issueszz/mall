package com.example.malladmin.service.impl;

import com.example.malladmin.service.CmsPrefrenceAreaService;
import com.example.mallmbg.mapper.CmsPrefrenceAreaMapper;
import com.example.mallmbg.model.CmsPrefrenceArea;
import com.example.mallmbg.model.CmsPrefrenceAreaExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CmsPrefrenceAreaServiceImpl implements CmsPrefrenceAreaService {
    @Autowired
    private CmsPrefrenceAreaMapper prefrenceAreaMapper;

    @Override
    public List<CmsPrefrenceArea> listAll() {
        return prefrenceAreaMapper.selectByExample(new CmsPrefrenceAreaExample());
    }
}
