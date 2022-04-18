package com.example.malladmin.service;

import com.example.mallmbg.model.UmsAdmin;
import com.example.mallmbg.model.UmsResource;

import java.util.List;

public interface UmsAdminCacheService {
    /*获取缓存中用户的信息*/
    UmsAdmin getAdmin(Long adminId);

    /*设置缓存用户信息*/
    void setAdmin(UmsAdmin admin);

    /*根据ID删除缓存用户信息*/
    void delAdmin(Long adminId);
}
