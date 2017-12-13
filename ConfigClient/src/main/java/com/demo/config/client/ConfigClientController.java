package com.demo.config.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xy
 */
@RestController
@RequestMapping("/config/client")
public class ConfigClientController {
    @Value("${hi}")
    private String hi;

    @Value("${info}")
    private String info;

    @RequestMapping("/hi")
    public String hi() {
        return hi;
    }

    @RequestMapping("/info")
    public String info() {
        return info;
    }
}
