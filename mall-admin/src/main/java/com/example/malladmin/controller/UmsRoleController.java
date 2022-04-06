package com.example.malladmin.controller;

import com.example.malladmin.service.UmsRoleService;
import com.example.mallcommon.api.CommonPage;
import com.example.mallcommon.api.CommonResult;
import com.example.mallmbg.model.UmsMenu;
import com.example.mallmbg.model.UmsRole;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
@Tag(name = "UmsRoleController", description = "用户角色管理")
public class UmsRoleController {
    @Autowired
    private UmsRoleService roleService;

    @GetMapping("/listAll")
    @Operation(description = "返回全部用户角色")
    public CommonResult<List<UmsRole>> listAll() {
        List<UmsRole> roles = roleService.list();
        return CommonResult.success(roles);
    }

    @GetMapping("/list")
    @Operation(description = "分页获取用户角色")
    public CommonResult<CommonPage<UmsRole>> list(@RequestParam(value = "keyword", required = false) String keyword,
                                                  @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                  @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        List<UmsRole> roles = roleService.list(keyword, pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(roles));
    }

    @GetMapping("/listMenu/{roleId}")
    @Operation(description = "获取角色相关菜单")
    public CommonResult<List<UmsMenu>> listMenu(@PathVariable Long roleId) {
        List<UmsMenu> menus = roleService.listMenu(roleId);
        return CommonResult.success(menus);
    }

    @PostMapping("/allocMenu")
    @Operation(description = "给角色分配菜单")
    public CommonResult allocMenu(@RequestParam Long roleId, @RequestParam List<Long> menuIds) {
        int count = roleService.allocMenu(roleId, menuIds);
        return CommonResult.success(count);
    }
}
