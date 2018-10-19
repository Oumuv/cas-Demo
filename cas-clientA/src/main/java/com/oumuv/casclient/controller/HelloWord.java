package com.oumuv.casclient.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 描述：
 *
 * @Author 欧银锋
 * @Date 2018/10/19 9:34
 **/
@Controller
public class HelloWord {

//    @ResponseBody
    @RequestMapping("hello")
    public String index() {
        return "index";
    }
}
