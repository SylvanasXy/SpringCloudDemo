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
     * 当type = null时,进行负载均衡:
     *       会在所有Eureka-Client的application.yml中查找
     *       spring.application.name和代码一致的服务,然后进行负载均衡,请求进行分发
     * @param type
     * @param name
     * @return
     */
    //@HystrixCommand 注解是断路器注解, fallbackMethod 为请求失败后调用的方法名
    @HystrixCommand(fallbackMethod = "hiServiceHystrix")
    public String hiService(Integer type, String name) {
        String url = "http://";
        url += type == null ? "service-all"
                : type == 0 ? "service-8081" : "service-8080" ;
        url += "/eureka/client/hi?name=" + name;
        return restTemplate.getForObject(url, String.class);
    }

    public String hiServiceHystrix(Integer type, String name) {
        return "Robbin reques fail, param: [name: " + name + ", type:" + type + "]";
    }
}
