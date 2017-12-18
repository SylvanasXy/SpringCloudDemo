# 项目介绍

### 简介
 1. 基于Spring Cloud框架搭建的项目Demo;
 2. 项目包含了包含了`Eureka`,`Ribbon`,`Fegin`,`Hystrix`(断路器),`Zuul`(路由网关),配置中心;
 
### 踩到的坑
 - `ConfigClient`项目中,利用*消息总线bus*去动态刷新配置文件时,不能使用IDEA自带的工具启动项目,
 必须使用`mvn spring-boot:run`命令行来启动项目.否则找不到`http://host:port/bus/refresh`映射地址(访问会报404错误).
 原因是IDEA自带的工具启动项目时,启动信息中未找到`Mapped [/bus/refresh]`信息,而命令行启动时,则可找到该信息;
 - `ConfigClient`去读取`ConfigServer`中`application.yml`配置文件中配置的git项目时,当git项目中配置文件有多个时,
 不知道为啥一定要指定配置文件的`name`属性,否则启动会报错(`@Value`注解失败的错误),该问题目前还未解决,也不知道原因;
 
### 参考链接:
 1. [Spring Cloud学习文档](http://blog.csdn.net/forezp/article/details/70148833)