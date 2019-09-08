package com.lrh;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/t")
    public String t(){

        return "ssssss";
    }

    @Autowired
    private CarInfo carInfo;

    @GetMapping("/")
    public CarInfo getCarInfo(){
        CarInfo newCar = new CarInfo();
        BeanUtils.copyProperties(carInfo, newCar);
        return newCar;
    }
}
