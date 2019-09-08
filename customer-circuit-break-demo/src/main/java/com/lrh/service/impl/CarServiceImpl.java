package com.lrh.service.impl;

import com.lrh.service.CarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class CarServiceImpl implements CarService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public String getCarInfo(String id) {
        String url = "http://wait-service/car/" + id;
        ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);
        log.info(forEntity.getBody());
        return forEntity.getBody();
    }

}
