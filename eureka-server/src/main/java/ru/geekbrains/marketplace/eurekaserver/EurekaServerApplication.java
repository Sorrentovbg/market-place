package ru.geekbrains.marketplace.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
//import org.springframework.cloud.openfeign.EnableFeignClients;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {
    public static void main(String[] args) { SpringApplication.run(EurekaServerApplication.class, args);}


//    @EnableWebSecurity
//    static class WebSecurityConfig extends WebSecurityConfigurerAdapter{
//        @Override
//        protected void configure(HttpSecurity http) throws Exception{
//            http.csrf().disable();
//        }
//    }
}

