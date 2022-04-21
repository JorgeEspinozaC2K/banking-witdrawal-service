package com.banking.witdrawal.service.app.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.banking.witdrawal.service.app.model.Witdrawal;

import reactor.core.publisher.Flux;

public interface WitdrawalRepository extends ReactiveMongoRepository<Witdrawal, String> {

	public Flux<Witdrawal> findByAccountId(String accountid);
}
