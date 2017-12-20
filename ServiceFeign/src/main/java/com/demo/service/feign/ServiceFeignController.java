package com.demo.service.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xy
 */
@RestController
@RequestMapping("/feign")
public class ServiceFeignController {
    @Autowired
    private IServiceFeignToServiceAll feignToServiceAll;

    @RequestMapping("/hi")
    public String hi(String name) {
        return feignToServiceAll.hiService(name);
    }
}

