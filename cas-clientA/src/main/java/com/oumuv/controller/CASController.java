package com.oumuv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @Author Oumuv
 * @Date 2018/10/23 16:59
 */
@Controller
public class CASController {

    /**
     * 主页
     * @param map
     * @return
     */
    @RequestMapping("index")
    public String index(ModelMap map) {
        map.addAttribute("name", "clien A");
        return "index";
    }

    /**
     * hello
     * @return
     */
    @RequestMapping("hello")
    public String hello() {
        return "hello";
    }

    /**
     * 退出
     * @param session
     * @return
     */
    @RequestMapping("logout")
    public String logout(HttpSession session) {
        session.invalidate();//销毁session
        //使用cas退出成功后,跳转到http://cas.client1.com:9001/logout/success
        return "redirect:http://cas.server.com:8443/cas/logout?service=http://cas.client1.com:9001/logout/success";
    }

    /**
     * 退出成功页
     * @param session
     * @return
     */
    @RequestMapping("logout/success")
    public String logoutsuccess(HttpSession session) {
        return "logoutsuccess";
    }

}
