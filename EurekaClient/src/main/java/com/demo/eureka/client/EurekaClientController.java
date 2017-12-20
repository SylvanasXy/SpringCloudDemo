package com.demo.eureka.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xy
 */
@RestController
@RequestMapping("/eureka/client")
public class EurekaClientController {
    @Value("${server.port}")
    private String port;
    @Value("${spring.application.name}")
    private String serviceName;

    @RequestMapping("/hi")
    public String hi(String name) {
        return String.format("serviceName:%s, port:%s, param:%s", serviceName, port, name);
    }
}
