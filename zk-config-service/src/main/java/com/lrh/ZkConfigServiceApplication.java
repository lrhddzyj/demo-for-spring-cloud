package com.lrh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.util.TimeZone;

@SpringBootApplication
@EnableDiscoveryClient
public class ZkConfigServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZkConfigServiceApplication.class, args);
    }

//    @Bean
//    public Jackson2ObjectMapperBuilderCustomizer jacksonBuilderCustomizer() {
//        return builder -> {
//            builder.indentOutput(true);
//            builder.timeZone(TimeZone.getTimeZone("Asia/Shanghai"));
//        };
//    }



}
