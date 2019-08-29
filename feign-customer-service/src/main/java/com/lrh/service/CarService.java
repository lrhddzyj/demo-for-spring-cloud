package com.lrh.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "eureka-waiter-service" )
public interface CarService {

    @GetMapping("/car/{id}")
    String getCardInfo(@PathVariable String id);
}
