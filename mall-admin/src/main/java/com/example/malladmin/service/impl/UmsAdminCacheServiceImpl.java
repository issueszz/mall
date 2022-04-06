package com.example.malladmin.service.impl;

import com.example.malladmin.service.UmsAdminCacheService;
import com.example.malladmin.service.UmsAdminService;
import com.example.mallcommon.service.RedisService;
import com.example.mallmbg.model.UmsAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UmsAdminCacheServiceImpl implements UmsAdminCacheService {
    @Autowired
    private RedisService redisService;

    @Autowired
    private UmsAdminService umsAdminService;

    @Value("${redis.database}")
    private String REDIS_DATABASE;

    @Value("${redis.expire.common}")
    private Long REDIS_EXPIRE;

    @Value("${redis.key.admin}")
    private String REDIS_KEY_ADMIN;


    @Override
    public UmsAdmin getAdmin(String username) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_ADMIN + ":" + username;
        return (UmsAdmin) redisService.get(key);
    }

    @Override
    public void setAdmin(UmsAdmin admin) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_ADMIN + ":" + admin.getUsername();
        redisService.set(key, admin, REDIS_EXPIRE);
    }

    @Override
    public void delAdmin(Long id) {
        UmsAdmin umsAdmin = umsAdminService.getItem(id);
        if (umsAdmin != null) {
            String key = REDIS_DATABASE + ":" + REDIS_KEY_ADMIN + ":" + umsAdmin.getUsername();
            redisService.del(key);
        }
    }
}
