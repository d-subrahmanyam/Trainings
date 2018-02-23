package com.subbu.estore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class EstoreCatalogServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstoreCatalogServiceApplication.class, args);
	}
}
