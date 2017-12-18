package com.demo.config.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 从ConfigServer配置的git地址中读取配置文件
 * 然后用@Value注解来判断是否读取成功
 * @author xy
 */
@RestController
@RefreshScope // 有此注解 才能实时刷新配置文件内容
@RequestMapping("/config/client")
public class ConfigClientController {

    @Value("${hi-client}")
    private String hiClient;

    @Value("${info-client}")
    private String infoClient;

    @Value("${hi-server}")
    private String hiServer;

    @Value("${info-server}")
    private String infoServer;

    @RequestMapping("/hi/{type}")
    public String hi(@PathVariable int type) {
        return type == 0 ? hiClient : hiServer;
    }

    @RequestMapping("/info/{type}")
    public String info(@PathVariable int type) {
        return type == 0 ? infoClient : infoServer;
    }
}
