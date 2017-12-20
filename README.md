# 项目介绍

### 简介
 1. 基于Spring Cloud框架搭建的项目Demo;
 2. 项目包含了包含了`Eureka`,`Ribbon`,`Fegin`,`Hystrix`(断路器),`Zuul`(路由网关),配置中心,消息总线(`Bus`),
 `Zipkin`(服务追踪组件);
 
### 踩到的坑
 - `ConfigClient`项目中,利用*消息总线bus*去动态刷新配置文件时,不能使用IDEA自带的工具启动项目,
 必须使用`mvn spring-boot:run`命令行来启动项目.否则找不到`http://host:port/bus/refresh`映射地址(访问会报404错误).
 原因是IDEA自带的工具启动项目时,启动信息中未找到`Mapped [/bus/refresh]`信息,而命令行启动时,则可找到该信息;
 - `ConfigClient`去读取`ConfigServer`中`application.yml`配置文件中配置的git项目时,当git项目中配置文件有多个时,
 不知道为啥一定要指定配置文件的`name`属性,否则启动会报错(`@Value`注解失败的错误),该问题目前还未解决,也不知道原因;
 
### 项目端口号说明
 - 说明: `Server`服务器端的端口号均>=8090;
 - `EurekaServer`: 8090;
 - `EurekaClient`: 8080 & 8081; 
 - `ServiceRibbon`: 8083;
 - `ServiceFeign`: 8084;
 - `ServiceZuul`: 8085;
 - `EurekaConfigServer`: 8091;
 - `ConfigServer`: 8092;
 - `ConfigClient`: 8086;
 - `ZipkinServer`: 8093;

### Target
 1. 解决项目中的`TODO`问题;
 2. 配置中心的`EurekaConfigServer`看能否集成到`EurekaServer`上;
 3. 现在是从另一个项目中读取配置,看能否集成到一个项目中去实现;
 
### 参考链接:
 1. [Spring Cloud学习文档](http://blog.csdn.net/forezp/article/details/70148833)