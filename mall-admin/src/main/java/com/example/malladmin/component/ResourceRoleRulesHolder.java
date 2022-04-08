package com.example.malladmin.component;

import com.example.malladmin.service.UmsResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ResourceRoleRulesHolder {
    @Autowired
    private UmsResourceService umsResourceService;

    @PostConstruct
    public void initResourceRolesMap() {
        umsResourceService.initResourceRolesMap();
    }
}
