package com.lrh.controller;

import com.lrh.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {

    @Autowired
    private CarService carService;


    @RequestMapping("/test/car/{id}")
    public String getCarInfo(@PathVariable String id){
        return carService.getCarInfo(id);
    }

}
