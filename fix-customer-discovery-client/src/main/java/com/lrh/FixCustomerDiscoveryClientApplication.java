package com.lrh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@SpringBootApplication
public class FixCustomerDiscoveryClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(FixCustomerDiscoveryClientApplication.class, args);
	}


	@Bean
	public FixCustomerDiscoveryClient fixCustomerDiscoveryClient(){
		return new FixCustomerDiscoveryClient();
	}

	@Bean
	public FixCustomerServerList fixCustomerServerList(){
		return new FixCustomerServerList();
	}

	@LoadBalanced
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder
				.setConnectTimeout(Duration.ofMillis(100))
				.setReadTimeout(Duration.ofMillis(500))
			//	.requestFactory(this::requestFactory)
				.build();
	}
}
