package com.example.malladmin.controller;

import com.example.malladmin.service.UmsMemberLevelService;
import com.example.mallcommon.api.CommonResult;
import com.example.mallmbg.model.UmsMemberLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/memberLevel")
public class UmsMemberLevelController {
    @Autowired
    private UmsMemberLevelService memberLevelService;

    @GetMapping("/list")
    public CommonResult<List<UmsMemberLevel>> listAll(@RequestParam("defaultStatus") Integer defaultStatus) {
        List<UmsMemberLevel> memberLevels = memberLevelService.list(defaultStatus);
        return CommonResult.success(memberLevels);
    }
}
