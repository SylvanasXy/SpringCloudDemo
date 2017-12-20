package com.demo.service.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xy
 */
@RestController
@RequestMapping("/ribbon")
public class ServiceRibbonController {
    @Autowired
    private ServiceRibbonService ribbonService;

    @RequestMapping("/hi")
    public String hi(String name) {
        return ribbonService.hiService(name);
    }
}
