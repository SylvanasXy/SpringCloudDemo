package com.demo.service.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 通过Ribbon+RestTemplate进行消费服务
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix //断路器
@EnableHystrixDashboard //断路器仪表盘架空
public class RibbonApplication {

	public static void main(String[] args) {
		SpringApplication.run(RibbonApplication.class, args);
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
}