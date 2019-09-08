package com.lrh;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "car")
@Data
@RefreshScope
public class CarInfo {

    private String name;

    private String weight;

}
