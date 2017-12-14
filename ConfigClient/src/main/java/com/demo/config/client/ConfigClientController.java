package com.demo.config.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 从ConfigServer配置的git地址中读取配置文件
 * 然后用@Value注解来判断是否读取成功
 * @author xy
 */
@RestController
@RequestMapping("/config/client")
public class ConfigClientController {

    @Value("${hi-client}")
    private String hiClient;

    @Value("${info-client}")
    private String infoClient;

    @RequestMapping("/hiClient")
    public String hi() {
        return hiClient;
    }

    @RequestMapping("/infoClient")
    public String info() {
        return infoClient;
    }
}
