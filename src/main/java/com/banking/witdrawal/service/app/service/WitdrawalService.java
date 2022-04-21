package com.banking.witdrawal.service.app.service;

import com.banking.witdrawal.service.app.model.Witdrawal;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface WitdrawalService {

	/**
	 * This method bring all the information from Witdrawal database
	 * @return Flux type Transaction
	 */
	public Flux<Witdrawal> findAll();
	
	/**
	 * This method bring a record from Witdrawal database
	 * @return Mono type Transaction
	 */
	public Mono<Witdrawal> finById(String id);
	
	/**
	 * This method save or update a record
	 * @return Mono type Transaction
	 */
	public Mono<Witdrawal> save(Witdrawal witdrawal);
	
	/**
	 * This method delete a record
	 * @return Mono type Void
	 */
	public Mono<Void> delete(Witdrawal witdrawal);
	
	/**
	 * This method finds witdrawals from an account
	 * @param customerId String
	 * @return Flux type witdrawal
	 */
	public Flux<Witdrawal> findByAccountId(String AccountId);
}
