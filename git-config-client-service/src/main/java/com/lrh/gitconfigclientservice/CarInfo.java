package com.lrh.gitconfigclientservice;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@ConfigurationProperties(prefix = "car")
@Data
@RefreshScope
public class CarInfo implements Serializable {

    private String name;

    private String weight;

}
