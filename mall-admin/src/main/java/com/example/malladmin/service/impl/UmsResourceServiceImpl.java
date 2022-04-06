package com.example.malladmin.service.impl;

import com.example.malladmin.service.UmsResourceService;
import com.example.mallmbg.mapper.UmsResourceMapper;
import com.example.mallmbg.model.UmsResource;
import com.example.mallmbg.model.UmsResourceExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UmsResourceServiceImpl implements UmsResourceService {
    @Autowired
    private UmsResourceMapper umsResourceMapper;

    @Override
    public List<UmsResource> listAll() {
       return umsResourceMapper.selectByExample(new UmsResourceExample());
    }
}
