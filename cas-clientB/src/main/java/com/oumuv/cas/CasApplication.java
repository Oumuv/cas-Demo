package com.oumuv.cas;

import com.oumuv.cas.controller.conf.CASConfig;
import net.unicon.cas.client.configuration.EnableCasClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;

@SpringBootApplication
@EnableCasClient//启用cas client
public class CasApplication {
    @Autowired
    private CASConfig casConfig;
    private FilterRegistrationBean filterRegistrationBean;
    public static void main(String[] args) {
        SpringApplication.run(CasApplication.class, args);

    }
}
