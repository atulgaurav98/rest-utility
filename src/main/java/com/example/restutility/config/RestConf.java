package com.example.restutility.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
@Configuration
public class RestConf {
    @Bean
    public RestTemplate getRest(){
        return new RestTemplate();
    }
}
