package com.example.malladmin.service;

import com.example.mallmbg.model.UmsMemberLevel;

import java.util.List;

public interface UmsMemberLevelService {
    List<UmsMemberLevel> list(Integer defaultStatus);
}
