package com.auth_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableDiscoveryClient 
@EnableJpaRepositories("com.auth_service.repository") 
@EntityScan("com.auth_service.model")
public class AuthServiceApplication {

	public static void main(String[] args) {
 		SpringApplication.run(AuthServiceApplication.class, args);
	}             
              
}    
  