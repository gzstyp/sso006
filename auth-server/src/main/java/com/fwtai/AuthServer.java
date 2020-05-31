package com.fwtai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

// http://www.javaboy.org/2020/0423/oauth2-sso.html
@SpringBootApplication
@EnableResourceServer
public class AuthServer{

    public static void main(String[] args) {
        SpringApplication.run(AuthServer.class, args);
    }
}