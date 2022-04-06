package com.example.malladmin.controller;

import com.example.malladmin.service.CmsSubjectService;
import com.example.mallcommon.api.CommonResult;
import com.example.mallmbg.model.CmsSubject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/subject")
public class CmsSubjectController {
    @Autowired
    private CmsSubjectService cmsSubjectService;

    @GetMapping("/listAll")
    public CommonResult<List<CmsSubject>> listAll() {
        List<CmsSubject> subjects = cmsSubjectService.listAll();
        return CommonResult.success(subjects);
    }
}
