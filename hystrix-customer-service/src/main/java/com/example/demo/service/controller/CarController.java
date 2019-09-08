package com.example.demo.service.controller;

import com.example.demo.service.CarService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/car/{id}")
    public String getCardInfo(@PathVariable String id) {
        return  carService.getCarInfo(id);
    }


    @GetMapping("/car/hystrix/{id}")
    @HystrixCommand(fallbackMethod = "getCardInfoByHystrixFallBack")
    public String getCardInfoByHystrix(@PathVariable String id) {
        return  carService.getCarInfo(id);
    }

    private String getCardInfoByHystrixFallBack(String id){
        return "fallback car info ";
    }


}
