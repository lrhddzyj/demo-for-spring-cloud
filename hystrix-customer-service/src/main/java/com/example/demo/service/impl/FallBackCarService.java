package com.example.demo.service.impl;

import com.example.demo.service.CarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class FallBackCarService implements CarService {

    @Override
    public String getCarInfo(String id) {
        log.info("car service fallback");
        return "fallback Car";
    }

}
