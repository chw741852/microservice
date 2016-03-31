#简单的微服务架构

## 一、module 介绍

1. microservice-discovery

   用eureka做服务发现

2. microservice-configserver

   spring cloud configserver做统一配置文件

3. microservice-hystrix-dashboard

   容错控制，监控所有配置了@EnableHystrix的app，只能监控配置了@HystrixCommand注解的方法；

   不必注册到eureka中

4. microservice-server

   server端，配置了@EnableHystrix