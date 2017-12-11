package com.demo.service.ribbon;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author xy
 */
@Service
public class RibbonService {

    @Autowired
    RestTemplate restTemplate;

    /**
     * 进行负载均衡:
     *       会在所有Eureka-Client的application.yml中查找
     *       spring.application.name和代码一致的服务,然后进行负载均衡,请求进行分发
     * @param name
     * @return
     */
    //@HystrixCommand 注解是断路器注解, fallbackMethod 为请求失败后调用的方法名
    @HystrixCommand(fallbackMethod = "hiServiceHystrix")
    public String hiService(String name) {
        String url = "http://service-all/eureka/client/hi?name=" + name;
        return restTemplate.getForObject(url, String.class);
    }

    /**
     * 请求失败时,断路器进行的方法
     * @param name
     * @return
     */
    public String hiServiceHystrix(String name) {
        return "Robbin reques fail, param: [name: " + name + "]";
    }
}
