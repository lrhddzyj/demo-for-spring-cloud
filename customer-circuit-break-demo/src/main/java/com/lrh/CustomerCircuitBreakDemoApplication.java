package com.lrh;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
@EnableAspectJAutoProxy
public class CustomerCircuitBreakDemoApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(CustomerCircuitBreakDemoApplication.class, args);
    }



    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
       return builder.build();
    }

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        searchSupplier();

//        readValue();
    }


    private void searchSupplier(){
        List<ServiceInstance> instances = discoveryClient.getInstances("wait-service");
        instances.stream().forEach(serviceInstance -> log.info("server addr {}  {}", serviceInstance.getHost(), serviceInstance.getPort()));
    }

    private void readValue(){
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://wait-service/car/1000", String.class);
        log.info(forEntity.getBody());
    }
}
