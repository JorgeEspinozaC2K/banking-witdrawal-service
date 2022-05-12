package com.banking.witdrawal.service.app.webclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.ReactiveCircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.ReactiveCircuitBreakerFactory;
import org.springframework.web.reactive.function.client.WebClient;

import com.banking.witdrawal.service.app.entity.OperationData;

import reactor.core.publisher.Mono;

public class WitdrawalWebClient {

	@SuppressWarnings("rawtypes")
	@Autowired
	private ReactiveCircuitBreakerFactory reactiveCircuitBreakerFactory;
	
	public Mono<Double> getAccountAmount(String id){
		return WebClient
				.create("http://localhost:8080")
				.get()
				.uri("/account/amount/{id}",id)
				.retrieve()
				.bodyToMono(Double.class)
				.transformDeferred(it -> {
                    ReactiveCircuitBreaker rcb = reactiveCircuitBreakerFactory.create("customDefaultCB");
                    return rcb.run(it, throwable -> Mono.empty());
                });
				
	}
	
	public Mono<Double> operateWitdraw(OperationData operationData){
		return WebClient
				.create("http://localhost:8080")
				.get()
				.uri("/operation/witdraw",operationData)
				.retrieve()
				.bodyToMono(Double.class)
				.transformDeferred(it -> {
                    ReactiveCircuitBreaker rcb = reactiveCircuitBreakerFactory.create("customDefaultCB");
                    return rcb.run(it, throwable -> Mono.empty());
                });
				
	}
	 
}
