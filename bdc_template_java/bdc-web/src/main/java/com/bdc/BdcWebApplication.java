package com.bdc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bdc.controllers.HelloController;

@Configuration
@EnableAutoConfiguration
//@SpringBootApplication
public class BdcWebApplication {

	public static void main(String[] args) {
		System.setProperty("spring.devtools.restart.enabled", "false");
		SpringApplication.run(BdcWebApplication.class, args);
	}
	
	@Bean
    public HelloController helloController(){
        return new HelloController();
    }
}
