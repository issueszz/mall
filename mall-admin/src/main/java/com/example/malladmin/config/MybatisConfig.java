package com.example.malladmin.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@MapperScan({"com.example.mallmbg.mapper", "com.example.malladmin.dao"})
public class MybatisConfig {
}
