package com.banking.witdrawal.service.app.webclient;

import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.Builder;

import com.banking.witdrawal.service.app.entity.Account;

import reactor.core.publisher.Mono;

public class WitdrawalWebClient {

	private Builder witdrawalWebClient = WebClient.builder();
	
	public Mono<Account> findAccount(String id){
		return witdrawalWebClient.build()
				.get()
				.uri("http://localhost:8083/{id}",id)
				.retrieve()
				.bodyToMono(Account.class);
				
	}
	 
}
