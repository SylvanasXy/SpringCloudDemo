package com.demo.service.feign;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Feign自带的断路器
 * 需实现刚才创建的接口
 * 当方法请求失败时,会调用该类里的同名方法
 * 需要把该类注入到IOC容器中
 * @author xy
 */
@Component
public class FeignHystrix implements IFeignToServiceAll {

    @Override
    public String hiService(@RequestParam("name") String name) {
        return "feign request fail!";
    }
}
