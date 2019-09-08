package com.lrh;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@ConfigurationProperties(prefix = "car")
@Data
@RefreshScope
@NoArgsConstructor
public class CarInfo {

    private String name;

    private String weight;

}
