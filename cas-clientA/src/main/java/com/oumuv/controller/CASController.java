package com.oumuv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class CASController {

    @RequestMapping("index")
    public String index(ModelMap map) {
        map.addAttribute("name", "clien A");
        return "index";
    }
    @RequestMapping("hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping("logout")
    public String logout(HttpSession session) {
        session.invalidate();
        //使用cas退出成功后,跳转到http://cas.client1.com:9001/logout/success
        return "redirect:http://cas.server.com:8443/cas/logout?service=http://cas.client1.com:9001/logout/success";

    }
    @RequestMapping("logout/success")
    public String logoutsuccess(HttpSession session) {
        session.invalidate();//销毁session
        return "logoutsuccess";
    }

}
