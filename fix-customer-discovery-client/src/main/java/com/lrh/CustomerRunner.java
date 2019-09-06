package com.lrh;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class CustomerRunner implements ApplicationRunner {

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
