package com.lrh.gitconfigclientservice;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "car")
@Data
public class CarInfo {

    private String name;

    private String weight;

}
