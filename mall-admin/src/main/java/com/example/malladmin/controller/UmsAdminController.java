package com.example.malladmin.controller;

import cn.hutool.core.collection.CollUtil;
import com.example.malladmin.dto.UmsAdminLoginParam;
import com.example.malladmin.dto.UmsAdminParam;
import com.example.malladmin.service.UmsAdminService;
import com.example.malladmin.service.UmsRoleService;
import com.example.mallcommon.api.CommonPage;
import com.example.mallcommon.api.CommonResult;
import com.example.mallcommon.domain.UserDto;
import com.example.mallmbg.model.UmsAdmin;
import com.example.mallmbg.model.UmsRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/admin")
public class UmsAdminController {
    @Autowired
    private UmsAdminService umsAdminService;

    @Autowired
    private UmsRoleService umsRoleService;

    /*用户注册接口*/
    @PostMapping("/register")
    public CommonResult register(@Validated @RequestBody UmsAdminParam umsAdminParam) {
        UmsAdmin umsAdmin = umsAdminService.register(umsAdminParam);
        if (umsAdmin == null) {
            return CommonResult.failed();
        }
        return CommonResult.success(umsAdmin);
    }

    @PostMapping("/login")
    public CommonResult login(@Validated @RequestBody UmsAdminLoginParam umsAdminLoginParam) {
        return umsAdminService.login(umsAdminLoginParam.getUsername(), umsAdminLoginParam.getPassword());
    }

    @PostMapping("/logout")
    public CommonResult logout() {
        return CommonResult.success(null);
    }

    @GetMapping("/info")
    public CommonResult getAdminInfo() {
        UmsAdmin umsAdmin = umsAdminService.getCurrentAdmin();
        Map<String, Object> data = new HashMap<>();
        /*写入用户名*/
        data.put("username", umsAdmin.getUsername());
        /*写入用户持有菜单列表*/
        data.put("menus", umsRoleService.getMenuList(umsAdmin.getId()));
        /*写入用户头像地址*/
        data.put("icon", umsAdmin.getIcon());
        List<UmsRole> roleList = umsAdminService.getRoleList(umsAdmin.getId());
        if (CollUtil.isNotEmpty(roleList)) {
            List<String> roles = roleList.stream().map(UmsRole::getName).collect(Collectors.toList());
            /*写入用户持有的角色*/
            data.put("roles", roles);
        }
        return CommonResult.success(data);
    }

    @GetMapping("/list")
    public CommonResult<CommonPage<UmsAdmin>> list(@RequestParam(value = "keyword", required = false) String keyword,
                                                   @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                   @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
       List<UmsAdmin> umsAdminList = umsAdminService.list(keyword, pageNum, pageSize);
       return CommonResult.success(CommonPage.restPage(umsAdminList));
    }

    @PostMapping("role/update")
    public CommonResult updateRole(@RequestParam("adminId") Long adminId,
                                   @RequestParam("roleIds") List<Long> roleIds) {
        int count = umsAdminService.updateRole(adminId, roleIds);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @PostMapping("update/{id}")
    public CommonResult update(@PathVariable("id") Long id, @RequestBody UmsAdmin umsAdmin) {
        int count = umsAdminService.update(id, umsAdmin);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @GetMapping("/loadByUsername")
    public UserDto loadByUsername(@RequestParam String username) {
        UserDto userDto = umsAdminService.loadUserByUsername(username);
        return userDto;
    }
}
