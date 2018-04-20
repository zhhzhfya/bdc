package com.bdc;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bdc.controllers.HelloController;

@Configuration
@EnableAutoConfiguration
public class BdcWebApplication {

	public static void main(String[] args) {
		System.setProperty("spring.devtools.restart.enabled", "false");
		SpringApplication run= new SpringApplication(BdcWebApplication.class);   
		run.setBannerMode(Banner.Mode.OFF);  
		run.run(args); 
	}
	
	@Bean
    public HelloController helloController(){
        return new HelloController();
    }
}
