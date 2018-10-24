package com.oumuv.cas.conf;

import org.jasig.cas.client.authentication.AuthenticationFilter;
import org.jasig.cas.client.session.SingleSignOutFilter;
import org.jasig.cas.client.session.SingleSignOutHttpSessionListener;
import org.jasig.cas.client.util.HttpServletRequestWrapperFilter;
import org.jasig.cas.client.validation.Cas30ProxyReceivingTicketValidationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.EventListener;
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
     * 登出过滤器
     * （这个过滤器不知道有什么作用）
     * @return
     */
    @Bean
    public FilterRegistrationBean filterSingleRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new SingleSignOutFilter());
        // 设定匹配的路径
        registration.addUrlPatterns("/logout");
        Map<String,String> initParameters = new HashMap<String, String>();
        initParameters.put("casServerUrlPrefix", casConfig.getServerUrlPrefix());
        registration.setInitParameters(initParameters);
        // 设定加载的顺序
        registration.setOrder(1);
        return registration;
    }

    /**
     * ticke验证器
     * @return
     */
    @Bean
    public FilterRegistrationBean filterValidationRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new Cas30ProxyReceivingTicketValidationFilter());
        // 设定匹配的路径
        registration.addUrlPatterns("/*");
        Map<String,String>  initParameters = new HashMap<String, String>();
        initParameters.put("casServerUrlPrefix", casConfig.getServerUrlPrefix());
        initParameters.put("serverName", casConfig.getServerName());
        initParameters.put("useSession", "true");
        registration.setInitParameters(initParameters);
        // 设定加载的顺序
        registration.setOrder(1);
        return registration;
    }

    /**
     * 授权过滤器，用于登录
     * @return
     */
    @Bean
    public FilterRegistrationBean filterAuthenticationRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new AuthenticationFilter());
        // 设定匹配的路径
        registration.addUrlPatterns("/*");
        Map<String,String>  initParameters = new HashMap<String, String>();
        initParameters.put("casServerLoginUrl", casConfig.getServerUrlPrefix());
        initParameters.put("serverName", casConfig.getServerName());
//        initParameters.put("ignorePattern", "/logout/success");
        //表示过滤所有
        initParameters.put("ignoreUrlPatternType", "SimpleUrlPatternMatcherStrategy");

        registration.setInitParameters(initParameters);
        // 设定加载的顺序
        registration.setOrder(1);
        return registration;
    }

    /**
     * wraper过滤器
     * @return
     */
    @Bean
    public FilterRegistrationBean filterWrapperRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new HttpServletRequestWrapperFilter());
        // 设定匹配的路径
        registration.addUrlPatterns("/*");
        // 设定加载的顺序
        registration.setOrder(1);
        return registration;
    }

    /**
     * 添加监听器
     * @return
     */
    @Bean
    public ServletListenerRegistrationBean<EventListener> singleSignOutListenerRegistration(){
        ServletListenerRegistrationBean<EventListener> registrationBean = new ServletListenerRegistrationBean<EventListener>();
        registrationBean.setListener(new SingleSignOutHttpSessionListener());
        registrationBean.setOrder(1);
        return registrationBean;
    }
}
