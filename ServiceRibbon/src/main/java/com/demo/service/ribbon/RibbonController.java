package com.demo.service.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author xy
 */
@RestController
@RequestMapping("/ribbon")
public class RibbonController {
    @Autowired
    RibbonService ribbonService;

    @RequestMapping("/hi")
    public String hi(String name) {
        System.out.println(">>>>>>>>>>>>>>>init ribbon service, time = " + new Date() + "<<<<<<<<<<<<<<<");
        return ribbonService.hiService(name);
    }
}
