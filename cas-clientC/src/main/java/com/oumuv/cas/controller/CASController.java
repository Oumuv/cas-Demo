package com.oumuv.cas.controller;

import com.oumuv.cas.conf.CASConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * 描述：
 *
 * @Author Oumuv
 * @Date 2018/10/19 12:15
 **/
@Controller
public class CASController {

    @Autowired
    private CASConfig casConfig;

    @RequestMapping("index")
    public String index(ModelMap map) {
        map.addAttribute("name", "clien C");
        return "index";
    }

    @RequestMapping("hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping("logout")
    public String logout(HttpSession session) {
        session.invalidate();
        //使用cas退出成功后,跳转到http://cas.client1.com:9003/logout/success
        return "redirect:"+casConfig.getClientLogoutUrl();

    }
    @RequestMapping("logout/success")
    public String logoutsuccess(HttpSession session) {
        return "logoutsuccess";
    }
}
