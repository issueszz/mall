package com.example.malladmin.service.impl;

import com.example.malladmin.service.CmsSubjectService;
import com.example.mallmbg.mapper.CmsSubjectMapper;
import com.example.mallmbg.model.CmsSubject;
import com.example.mallmbg.model.CmsSubjectExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CmsSubjectServiceImpl implements CmsSubjectService {
    @Autowired
    private CmsSubjectMapper subjectMapper;

    @Override
    public List<CmsSubject> listAll() {
        return subjectMapper.selectByExample(new CmsSubjectExample());
    }
}
