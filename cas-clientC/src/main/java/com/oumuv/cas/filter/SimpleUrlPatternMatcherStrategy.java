package com.oumuv.cas.filter;

import com.oumuv.cas.conf.CASConfig;
import org.jasig.cas.client.authentication.UrlPatternMatcherStrategy;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 描述：
 *
 * @Author 欧银锋
 * @Date 2018/10/24 11:01
 **/
@WebFilter(urlPatterns = "/*")
public class SimpleUrlPatternMatcherStrategy implements UrlPatternMatcherStrategy {

    /**
     * 过滤url
     * @param url
     * @return
     */
    @Override
    public boolean matches(String url) {
        //过滤的url
        return url.contains("/logout/success");
    }

    /**
     * 正在表达式过滤方法
     * @param s
     */
    @Override
    public void setPattern(String s) {

    }
}
