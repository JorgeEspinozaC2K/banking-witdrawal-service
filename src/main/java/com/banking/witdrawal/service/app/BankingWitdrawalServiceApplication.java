package com.banking.witdrawal.service.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class BankingWitdrawalServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankingWitdrawalServiceApplication.class, args);
	}

}
