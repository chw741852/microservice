#简单的微服务架构

[docker版本](https://github.com/chw741852/microservice)

## 一、module 介绍

1. microservice-discovery

   用eureka做服务发现

2. microservice-configserver

   spring cloud configserver做统一配置文件

3. microservice-hystrix-dashboard

   容错控制，监控所有配置了@EnableHystrix的app，只能监控配置了@HystrixCommand注解的方法；

   不必注册到eureka中

4. microservice-server

   * 连接本地数据库`test`
   * 测试服务，配置了@EnableHystrix;
   * 配置了log4j2, 使用阿里druid和mybatis-spring-boot-starter连接MySQL;
   * 配置了spring-cloud-bus,默认使用本地rabbitMQ;

5. microservice-service-security

   * spring security 权限管理
   * thymeleaf模板
   * 使用redis共享session


## 二、gradle command
gradle build -x test  // build jar without test