package com.demo.service.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 定义一个接口
 * 通过@FeignClient来指定调用哪个服务
 * 如下所示,就是调用spring.application.name = service-all客户端的代码
 * @author xy
 */
@FeignClient(value = "service-all", fallback = ServiceFeignHystrix.class)
public interface IServiceFeignToServiceAll {

    /**
     * 在方法上加上 @RequestMapping 注解
     * 地址为 客户端的映射地址,否则找不到
     * 参数名要加上 @RequestParam 注解,否则参数会为null
     * @param name
     * @return
     */
    @RequestMapping("/eureka/client/hi")
    String hiService(@RequestParam("name") String name);
}
