package com.demo.eureka.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;

/**
 * Eureka 客户端
 * 支持分布式
 */
@SpringBootApplication
@EnableEurekaClient
public class EurekaClientApplication {
	public static void main(String[] args) {
		SpringApplication.run(EurekaClientApplication.class, args);
	}

	/**
	 * 使用zipkin服务追踪监控组件时,必须要声明该方法
	 * @return
	 */
	@Bean
	public AlwaysSampler defaultSampler() {
		return new AlwaysSampler();
	}
}
