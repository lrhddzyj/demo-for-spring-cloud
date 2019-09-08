package com.lrh;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@Slf4j
public class ConsulConfigServiceApplication{

    public static void main(String[] args) {
        SpringApplication.run(ConsulConfigServiceApplication.class, args);
    }

    @Autowired
    private CarInfo carInfo1;

    @GetMapping("/")
    public CarInfo carInfo(){
        log.info(carInfo1.getName());
        log.info(carInfo1.getWeight());
        CarInfo carInfo = new CarInfo();
        carInfo.setName(carInfo1.getName());
        carInfo.setWeight(carInfo1.getWeight());
        return carInfo;
    }

}
