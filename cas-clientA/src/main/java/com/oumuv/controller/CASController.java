package com.oumuv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CASController {


    @RequestMapping("index")
    public String index(ModelMap map) {
        map.addAttribute("name", "clien A");
        return "index";
    }
}
