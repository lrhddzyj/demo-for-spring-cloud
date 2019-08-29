package com.lrh;

import com.lrh.service.CarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CustomRunner implements ApplicationRunner {

    @Autowired
    private CarService carService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("!!!");
        log.info(carService.getCardInfo("100"));
    }
}
