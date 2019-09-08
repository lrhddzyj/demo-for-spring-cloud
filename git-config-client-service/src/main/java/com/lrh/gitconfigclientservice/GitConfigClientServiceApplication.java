package com.lrh.gitconfigclientservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
@Slf4j
public class GitConfigClientServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GitConfigClientServiceApplication.class, args);
	}


	@Autowired
	private CarInfo initCarInfo;

	@GetMapping("/")
	public CarInfo getCarInfo(){
		CarInfo carInfo = new CarInfo();
		carInfo.setName(initCarInfo.getName());
		carInfo.setWeight(initCarInfo.getWeight());
		return carInfo;
	}

	@Bean("objectMapper")
	public ObjectMapper myMapper() {
		return new ObjectMapper().disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
	}

}
