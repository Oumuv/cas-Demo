package com.oumuv.cas.controller.util;

import com.oumuv.cas.controller.conf.CASConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 描述：
 *
 * @Author 欧银锋
 * @Date 2018/10/24 11:49
 **/
@PropertySource("cas")
@ConfigurationProperties
public class SSOClientUtil {

//    @Value("server-url-prefix")
    private static String serverUrlPrefix;
    private static String serverLoginUrl;



    public static void redirectToSSOURL(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect(serverUrlPrefix);
    }
}
