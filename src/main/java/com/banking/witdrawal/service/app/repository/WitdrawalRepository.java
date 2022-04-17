package com.banking.witdrawal.service.app.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.banking.witdrawal.service.app.model.Witdrawal;

public interface WitdrawalRepository extends ReactiveMongoRepository<Witdrawal, String> {

}
