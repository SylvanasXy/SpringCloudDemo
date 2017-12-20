package com.demo.eureka.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 该EurekaServer为 配置中心的服务端
 * 为配置中心的集群使用
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaConfigServerApplication.class, args);
	}
}
