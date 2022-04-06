package com.example.malladmin.controller;

import com.example.malladmin.dto.UmsMenuNode;
import com.example.malladmin.service.UmsMenuService;
import com.example.mallcommon.api.CommonPage;
import com.example.mallcommon.api.CommonResult;
import com.example.mallmbg.model.UmsMenu;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
@Tag(name = "UmsMenuController", description = "后台菜单管理")
public class UmsMenuController {
    @Autowired
    private UmsMenuService menuService;

    @GetMapping("/list/{parentId}")
    @Operation(description = "分页查询后台菜单")
    public CommonResult<CommonPage<UmsMenu>> getList(@PathVariable("parentId") Long parentId,
                                                        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                        @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        List<UmsMenu> menus = menuService.list(parentId, pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(menus));
    }

    @PostMapping("/create")
    @Operation(description = "创建菜单")
    public CommonResult create(@RequestBody UmsMenu umsMenu) {
        int count = menuService.create(umsMenu);
        if (count > 0) {
             return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @GetMapping("/treeList")
    @Operation(description = "返回菜单树形结构")
    public CommonResult<List<UmsMenuNode>> treeList() {
        List<UmsMenuNode> menuNodes = menuService.treeList();
        return CommonResult.success(menuNodes);
    }
}
