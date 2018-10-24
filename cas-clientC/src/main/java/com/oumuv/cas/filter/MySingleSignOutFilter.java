package com.oumuv.cas.filter;

import com.oumuv.cas.controller.conf.CASConfig;
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
public class MySingleSignOutFilter implements Filter {
    @Autowired
    private CASConfig casConfig;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("进入cas filter");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse rep = (HttpServletResponse) servletResponse;
        HttpSession session = ((HttpServletRequest) servletRequest).getSession();
        System.out.println("过滤器");
        //是否有局部会话
        Boolean isLongin = (Boolean) session.getAttribute("isLongin");
        if (isLongin != null && isLongin) {//是否已登录
            filterChain.doFilter(servletRequest,servletResponse);//已登录，放行请求
            return;
        }
        //没有局部会话，重定向到cas，检测是否有其他的系统登录

    }

    @Override
    public void destroy() {
        System.out.println("进入cas filter");
    }
}
