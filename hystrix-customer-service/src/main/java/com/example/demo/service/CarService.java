package com.example.demo.service;

import com.example.demo.service.impl.FallBackCarService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "wait-service", contextId = "carService", path = "/car", fallback = FallBackCarService.class)
//@FeignClient(name = "wait-service", contextId = "carService", path = "/car")
public interface CarService {

    @GetMapping("/{id}")
     String getCarInfo(@PathVariable String id);

}
