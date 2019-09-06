package com.lrh;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class ConsulCustomerServiceApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(ConsulCustomerServiceApplication.class, args);
    }

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder
                .setConnectTimeout(Duration.ofMillis(100))
                .setReadTimeout(Duration.ofMillis(500))
//				.requestFactory(this::requestFactory)
                .build();
    }

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        showServiceInstance();
        readFromRemote();
    }


    /**
     * 展示服务实例
     */
    private void showServiceInstance(){
        log.info("DiscoveryClient: {}", discoveryClient.getClass().getName());
        discoveryClient.getInstances("wait-service").forEach(serviceInstance -> {
            log.info("[server host:{}  server port:{}]", serviceInstance.getHost(), serviceInstance.getPort());
        });
    }

    private void readFromRemote(){
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://wait-service/car/100", String.class);
        log.info(responseEntity.getBody());
    }


}
