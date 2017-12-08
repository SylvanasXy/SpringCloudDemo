package com.demo.service.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * 通过Feign来实现消费服务
 * Feign采用的是基于接口的注解
 * Feign整合了Ribbon
 * 默认实现了负载均衡
 */
@SpringBootApplication
@EnableDiscoveryClient //消费服务注解
@EnableFeignClients //Feign注解
@EnableHystrixDashboard //断路器(Feign自带断路器,假如不需要断路器监控,则可以不需要这和下面的注解)
@EnableCircuitBreaker //断路器监控注解
public class FeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeignApplication.class, args);
	}
}
