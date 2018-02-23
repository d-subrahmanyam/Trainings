package com.subbu.estore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EstoreUserServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstoreUserServicesApplication.class, args);
	}
}
