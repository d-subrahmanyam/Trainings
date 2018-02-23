package com.subbu.estore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EstoreDiscoveryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstoreDiscoveryServiceApplication.class, args);
	}
}
