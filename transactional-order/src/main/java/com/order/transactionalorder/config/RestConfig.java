package com.order.transactionalorder.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @创建人 zwj
 * @创建时间 2021/8/4
 * @描述
 */
@Configuration
public class RestConfig {
    @Bean
    public RestTemplate getRestTemplate(){
        return  new RestTemplate();
    }
}
