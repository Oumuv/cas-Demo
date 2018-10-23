package com.oumuv.cas.controller.conf;

import org.jasig.cas.client.authentication.AuthenticationFilter;
import org.jasig.cas.client.session.SingleSignOutFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述：
 *
 * @Author 欧银锋
 * @Date 2018/10/23 16:59
 **/
@Configuration
public class CASAutoConfig {
    @Autowired
    private CASConfig casConfig;

    /**
     * 登录过滤器
     * @return
     */
    @Bean
    public FilterRegistrationBean filterSingleRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new SingleSignOutFilter());
        Map<String,String> initParameters = new HashMap<String, String>();
        initParameters.put("casServerUrlPrefix", casConfig.getServerUrlPrefix());
        registration.setInitParameters(initParameters);
        // 设定匹配的路径
        registration.addUrlPatterns("/*");
        // 设定加载的顺序
        registration.setOrder(1);
        return registration;
    }


    /**
     * 认证过滤器
     * @return
     */
    @Bean
    public FilterRegistrationBean authenticationFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new AuthenticationFilter());
        Map<String,String> initParameters = new HashMap<String, String>();
//        initParameters.put("casServerUrlPrefix", casConfig.getServerUrlPrefix());
        registration.setInitParameters(initParameters);
        // 设定匹配的路径
        registration.addUrlPatterns("/*");
        // 设定加载的顺序
        registration.setOrder(1);
        return registration;
    }


}
