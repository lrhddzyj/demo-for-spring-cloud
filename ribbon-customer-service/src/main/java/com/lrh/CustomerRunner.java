package com.lrh;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class CustomerRunner implements ApplicationRunner {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        showServiceInstances();
        readMenu();
    }


    private void showServiceInstances() {
        log.info("DiscoveryClient: {}", discoveryClient.getClass().getName());
        discoveryClient.getInstances("eureka-waiter-service").forEach(s -> {
            log.info("Host: {}, Port: {}", s.getHost(), s.getPort());
        });
    }

    private void readMenu() {
//        ParameterizedTypeReference<List<Coffee>> ptr =
//                new ParameterizedTypeReference<List<Coffee>>() {};
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://eureka-waiter-service/car/100", String.class);
//                .exchange("http://eureka-waiter-service/car/", HttpMethod.GET, new HttpEntity<>());
        log.info(responseEntity.toString());
        log.info(responseEntity.getBody());
//        list.getBody().forEach(c -> log.info("Coffee: {}", c));
    }
}
