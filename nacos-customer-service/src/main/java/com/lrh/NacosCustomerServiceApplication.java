package com.lrh;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class NacosCustomerServiceApplication extends SpringBootServletInitializer  implements  CommandLineRunner {

    public static void main(String[] args) {

        SpringApplication.run(NacosCustomerServiceApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.web(WebApplicationType.NONE).sources(NacosCustomerServiceApplication.class);
    }

    @Override
    public void run(String... args) throws Exception {
        dicvover();
        readMenu();
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


    public void dicvover(){
        List<ServiceInstance> instances = discoveryClient.getInstances("wait-service");
        instances.stream().forEach(instance -> {
            log.info("Host {} Port {}", instance.getHost(), instance.getPort());
        });
    }


    public void readMenu(){
        ResponseEntity<String> entity = restTemplate.getForEntity("http://wait-service/car/100", String.class);
        log.info("response context {}", entity.getBody());

    }



}
