package com.example.malladmin.service;

import com.example.mallmbg.model.UmsResource;

import java.util.List;
import java.util.Map;

public interface  UmsResourceService {
    /*获取所有的资源*/
    List<UmsResource> listAll();

    /*初始化资源角色规则*/
    Map<String, List<String>> initResourceRolesMap();
}
