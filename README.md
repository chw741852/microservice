#简单的微服务架构

[普通版本](https://github.com/chw741852/microservice/tree/ordinary)

## 一、module 介绍

1. microservice-discovery

   用eureka做服务发现

2. microservice-configserver

   spring cloud configserver做统一配置文件

3. microservice-hystrix-dashboard

   容错控制，监控所有配置了@EnableHystrix的app，只能监控配置了@HystrixCommand注解的方法；

   不必注册到eureka中

4. microservice-server

  * 测试服务，配置了@EnableHystrix;
  * 配置了log4j2, 使用阿里druid和mybatis-spring-boot-starter连接MySQL;
  * 配置了spring-cloud-bus,默认使用本地rabbitMQ;
  * 依赖mysql
   
## 二、运行
* mac环境
```
cd microservice
./gradlew buildImage
.....
cd docker
docker-compose up
```
* linux环境
需要注释掉build.gradle中的task docker，然后执行以上命令
如果提示连接不上docker，是因为默认启动`service docker start`并未暴露2375端口；
请执行
```
service docker stop
docker -d -H unix:///var/run/docker.sock -H 0.0.0.0:2375
```
* 单独运行
```
docker run --name server2 --net docker_default --link docker_discovery_1 --link docker_configserver_1 --link docker_mysql_1 -d -p 8081:8080 microservice/server:1.0-SNAPSHOT
```