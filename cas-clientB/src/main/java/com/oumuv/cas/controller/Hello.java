package com.oumuv.cas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述：
 *
 * @Author 欧银锋
 * @Date 2018/10/19 12:15
 **/
@Controller
public class Hello {

    @RequestMapping("index")
    public String index(ModelMap map) {
        map.addAttribute("name", "clien B");
        return "index";
    }

    @RequestMapping("hello")
    public String hello() {
        return "hello";
    }
}
