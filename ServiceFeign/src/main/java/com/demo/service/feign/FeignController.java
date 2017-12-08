package com.demo.service.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return feignToServiceAll.hiService(name);
    }
}
