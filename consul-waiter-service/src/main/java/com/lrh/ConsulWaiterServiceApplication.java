package com.lrh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ConsulWaiterServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsulWaiterServiceApplication.class, args);
	}

}
