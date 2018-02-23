package com.subbu.estore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class EstoreConfigServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstoreConfigServiceApplication.class, args);
	}
}
