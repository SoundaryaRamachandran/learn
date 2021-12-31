package com.springboot.employeemangconf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.jms.annotation.EnableJms;
/**
 * Springbootemployeemanagementsystem1Application is the main class
 * @author Soundarya
 * Since 20/12/2021
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableJms
public class Springbootemployeemanagementsystem1Application {

	public static void main(String[] args) {
		SpringApplication.run(Springbootemployeemanagementsystem1Application.class, args);
	}
}
