package com.coursedash.client;


import com.coursedash.client.config.property.ApiProperties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.time.LocalDateTime;


@SpringBootApplication()
@EnableConfigurationProperties(ApiProperties.class)
public class ClientApplication {

	public static void main(String[] args) {


		SpringApplication.run(ClientApplication.class, args);
	}

}
