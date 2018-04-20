package com.bdc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
public class BdcServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BdcServiceApplication.class, args);
	}
}
