package com.microservice.springgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringgatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringgatewayApplication.class, args);
	}

}
