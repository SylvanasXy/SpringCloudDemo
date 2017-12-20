package com.demo.service.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 通过Ribbon+RestTemplate进行消费服务
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix //断路器
@EnableHystrixDashboard //断路器仪表盘架空
public class ServiceRibbonApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceRibbonApplication.class, args);
	}

	/**
	 * 开启负载均衡
	 * @return
	 */
	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
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
