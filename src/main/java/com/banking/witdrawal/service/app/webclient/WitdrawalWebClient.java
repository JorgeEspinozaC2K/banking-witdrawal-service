package com.banking.witdrawal.service.app.webclient;

import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.Builder;

import com.banking.witdrawal.service.app.entity.OperationData;

import reactor.core.publisher.Mono;

public class WitdrawalWebClient {

	private Builder witdrawalWebClient = WebClient.builder();
	
	public Mono<Double> getAccountAmount(String id){
		return witdrawalWebClient.build()
				.get()
				.uri("http://localhost:8080/account/amount/{id}",id)
				.retrieve()
				.bodyToMono(Double.class);
				
	}
	
	public Mono<Double> operateWitdraw(OperationData operationData){
		return witdrawalWebClient.build()
				.get()
				.uri("http://localhost:8080/operation/witdraw",operationData)
				.retrieve()
				.bodyToMono(Double.class);
				
	}
	 
}
