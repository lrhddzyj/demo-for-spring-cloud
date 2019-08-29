package com.lrh.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {

    @GetMapping("/car/{id}")
    public String getCarInfo(@PathVariable String id){

        return "CAR : "+ id;
    }
}
