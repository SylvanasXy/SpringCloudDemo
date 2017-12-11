package com.demo.service.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author xy
 */
@RestController
@RequestMapping("/feign")
public class FeignController {
    /**
     * 虽然idea编译器报错,但是并不影响
     */
    @Autowired
    IFeignToServiceAll feignToServiceAll;

    @RequestMapping("/hi")
    public String hi(String name) {
        System.out.println(">>>>>>>>>>>>>>>init feign service, time = " + new Date() + "<<<<<<<<<<<<<<<");
        return feignToServiceAll.hiService(name);
    }
}

