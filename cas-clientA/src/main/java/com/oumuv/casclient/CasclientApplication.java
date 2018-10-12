package com.oumuv.casclient;

import net.unicon.cas.client.configuration.EnableCasClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableCasClient//开启cas支持
public class CasclientApplication {

    public static void main(String[] args) {
        SpringApplication.run(CasclientApplication.class, args);
    }
}
