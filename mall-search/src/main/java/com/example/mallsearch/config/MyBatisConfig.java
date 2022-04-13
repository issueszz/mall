package com.example.mallsearch.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.example.mallmbg.mapper", "com.example.mallsearch.dao"})
public class MyBatisConfig {
}
