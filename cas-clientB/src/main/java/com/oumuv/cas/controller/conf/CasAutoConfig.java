package com.oumuv.cas.controller.conf;

import org.jasig.cas.client.authentication.AuthenticationFilter;
import org.jasig.cas.client.session.SingleSignOutFilter;
import org.jasig.cas.client.session.SingleSignOutHttpSessionListener;
import org.jasig.cas.client.util.AssertionThreadLocalFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * 描述：
 *
 * @Author 欧银锋
 * @Date 2018/10/19 16:41
 **/
@Configuration
@Component
public class CasAutoConfig {

    @Autowired
    private CasConfig casConfig;

    private static boolean casEnabled  = true;

    public CasAutoConfig() {}

    @Bean
    public CasAutoConfig getCasAutoconfig(){
        return new CasAutoConfig();
    }

    /**
     * 用于实现单点登出功能
     */
    @Bean
    public ServletListenerRegistrationBean<SingleSignOutHttpSessionListener> singleSignOutHttpSessionListener() {
        ServletListenerRegistrationBean<SingleSignOutHttpSessionListener> listener = new ServletListenerRegistrationBean<>();
        listener.setEnabled(casEnabled);
        listener.setListener(new SingleSignOutHttpSessionListener());
        listener.setOrder(1);
        return listener ;
    }

    /**
     * 该过滤器用于实现单点登出功能，单点退出配置，一定要放在其他filter之前
     */
    @Bean
    public FilterRegistrationBean singleSignOutFilter() {
        FilterRegistrationBean filterRegistration = new FilterRegistrationBean();
        filterRegistration.setFilter(new SingleSignOutFilter());
        filterRegistration.setEnabled(casEnabled);
        filterRegistration.addUrlPatterns("/*" );
        filterRegistration.addInitParameter("casServerUrlPrefix" , casConfig .getCasServerUrlPrefix());
        filterRegistration.setOrder(2);
        return filterRegistration ;
    }

    /**
     * 该过滤器负责用户的认证工作
     */
    @Bean
    public FilterRegistrationBean authenticationFilter() {
        FilterRegistrationBean filterRegistration = new FilterRegistrationBean();
        filterRegistration.setFilter(new AuthenticationFilter());
        filterRegistration.setEnabled(casEnabled);
        filterRegistration.addUrlPatterns("/*" );
        filterRegistration.addInitParameter("casServerLoginUrl" , casConfig .getCasServerLoginUrl());
        filterRegistration.addInitParameter("casPassUrl" , casConfig.getCasPassUrl());
        filterRegistration.addInitParameter("serverName" , casConfig.getServerName());
        filterRegistration.addInitParameter("renew" , casConfig.isRenew() ? "true" :"false" );
        filterRegistration.addInitParameter("gateway" , casConfig.isGateway() ? "true" :"false" );
        filterRegistration.addInitParameter("casResource" , casConfig.getResource());
        filterRegistration.setOrder(3);
        return filterRegistration ;
    }

    /**
     * 该过滤器负责对Ticket的校验工作
     */
    @Bean
    public FilterRegistrationBean cas20ProxyReceivingTicketValidationFilter() {
        FilterRegistrationBean filterRegistration = new FilterRegistrationBean();
//        UboxCasProxyReceivingTicketValidationFilter uboxCasProxyReceivingTicketValidationFilter = new UboxCasProxyReceivingTicketValidationFilter();
//        filterRegistration.setFilter(uboxCasProxyReceivingTicketValidationFilter );
        filterRegistration.setEnabled(casEnabled);
        filterRegistration.addUrlPatterns("/*" );
        filterRegistration.addInitParameter("casServerUrlPrefix" , casConfig .getCasServerUrlPrefix());
        filterRegistration.addInitParameter("serverName" , casConfig.getServerName());
        filterRegistration.addInitParameter("useSession" , casConfig.isUseSession() ? "true" :"false" );
        filterRegistration.addInitParameter("exceptionOnValidationFailure" , casConfig.isExceptionOnValidationFailure() ? "true":"false" );
        filterRegistration.addInitParameter("redirectAfterValidation" , casConfig .isRedirectAfterValidation() ? "true":"false" );
        filterRegistration.setOrder(4);
        return filterRegistration ;
    }

    /**
     * 该过滤器使得可以通过org.jasig.cas.client.util.AssertionHolder来获取用户的登录名。
     * 比如AssertionHolder.getAssertion().getPrincipal().getName()。
     * 这个类把Assertion信息放在ThreadLocal变量中，这样应用程序不在web层也能够获取到当前登录信息
     */
    @Bean
    public FilterRegistrationBean assertionThreadLocalFilter() {
        FilterRegistrationBean filterRegistration = new FilterRegistrationBean();
        filterRegistration.setFilter(new AssertionThreadLocalFilter());
        filterRegistration.setEnabled(true);
        filterRegistration.addUrlPatterns("/*" );
        filterRegistration.setOrder(5);
        return filterRegistration ;
    }

}
