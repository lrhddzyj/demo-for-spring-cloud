package com.lrh.gitconfigclientservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class GitConfigClientServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GitConfigClientServiceApplication.class, args);
	}


	@Autowired
	private CarInfo carInfo;

	@GetMapping("/")
	public CarInfo getCarInfo(){
		return carInfo;
	}

}
