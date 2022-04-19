## 项目介绍

`mall`项目是一套微服务电商系统，包括前台商城系统及后台管理系统，基于SpringBoot+MyBatis实现。 前台商城系统包含首页门户、商品推荐、商品搜索、商品展示、购物车、订单流程、会员中心、客户服务、帮助中心等模块；后台管理系统包含商品管理、订单管理、会员管理、促销管理、运营管理、内容管理、统计报表、财务管理、权限管理、设置等模块。同时在该电商基础上集成了注册中心、配置中心、监控中心、网关等系统功能；

## 组织结构
``` lua
mall
├── mall-admin ---后台管理系统服务
├── mall-auth  --- 基于Spring Security Oauth2的统一认证中心
├── mall-common ---工具类及通用代码模块
├── mall-gateway ---基于Spring Cloud Gateway的微服务网关服务
├── mall-mbg ---MyBatisGenerator生产的数据库操作代码块
├── mall-monitor ---基于Spring Boot Admin的微服务监控中心
├── mall-portal  ---移动端商城服务
├── mall-search  --- 基于Elasticsearch的商品搜索服务
```
## 技术选型
### 后端技术
| 技术                   | 说明                 | 官网                                                 |
| ---------------------- | -------------------- | ---------------------------------------------------- |
| Spring Cloud           | 微服务框架           | https://spring.io/projects/spring-cloud              |
| Spring Cloud Alibaba   | 微服务框架           | https://github.com/alibaba/spring-cloud-alibaba      |
| Spring Boot            | 容器+MVC框架         | https://spring.io/projects/spring-boot               |
| Spring Security Oauth2 | 认证和授权框架       | https://spring.io/projects/spring-security-oauth     |
| MyBatis                | ORM框架              | http://www.mybatis.org/mybatis-3/zh/index.html       |
| MyBatisGenerator       | 数据层代码生成       | http://www.mybatis.org/generator/index.html          |
| PageHelper             | MyBatis物理分页插件  | http://git.oschina.net/free/Mybatis_PageHelper       |
| Knife4j                | 文档生产工具         | https://github.com/xiaoymin/swagger-bootstrap-ui     |
| Elasticsearch          | 搜索引擎             | https://github.com/elastic/elasticsearch             |
| RabbitMq               | 消息队列             | https://www.rabbitmq.com/                            |
| Redis                  | 分布式缓存           | https://redis.io/                                    |
| MongoDb                | NoSql数据库          | https://www.mongodb.com/                             |
| Docker                 | 应用容器引擎         | https://www.docker.com/                              |
| Druid                  | 数据库连接池         | https://github.com/alibaba/druid                     |
| OSS                    | 对象存储             | https://github.com/aliyun/aliyun-oss-java-sdk        |
| MinIO                  | 对象存储             | https://github.com/minio/minio                       |
| JWT                    | JWT登录支持          | https://github.com/jwtk/jjwt                         |
| LogStash               | 日志收集             | https://github.com/logstash/logstash-logback-encoder |
| Lombok                 | 简化对象封装工具     | https://github.com/rzwitserloot/lombok               |
| Seata                  | 全局事务管理框架     | https://github.com/seata/seata                       |
| Portainer              | 可视化Docker容器管理 | https://github.com/portainer/portainer               |
| Jenkins                | 自动化部署工具       | https://github.com/jenkinsci/jenkins                 |
| Kubernetes             | 应用容器管理平台     | https://kubernetes.io/                               |

## 项目排期
1. `mall-common`工具类及通用代码模块(✅)
    1. 统一接口返回值(✅)
    2. 添加AOP切面实现接口日志记录(✅)
    3. 整合redis，注入StringRedisTemplate，实现RedisService接口(✅)
    4. 等等
2. `mall-mbg`MyBatisGenerator生产的数据库操作模块(✅)
    1. MyBatis Generator通过数据库直接生成实体类、单表CURD代码、mapper.xml文件
3. `mall-auth`基于Spring Security Oauth2统一认证中心(✅)
    1. 配置password模式认证服务，refresh_token模式刷新令牌
    2. 提供返回令牌接口
    3. 为网关提供FSA公钥接口验证签名是否合法
4. `mall-gateway`基于Spring Cloud Gateway网关服务(✅) 
5. `mall-admin`后台管理系统服务()
6. `mall-search`基于Elasticsearch的商品搜索服务(✅)
7. `mall-monitor`基于Spring Boot Admin的微服务监控中心(✅)
8. `mall-portal`移动端商城服务


