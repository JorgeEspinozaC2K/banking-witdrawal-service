package com.banking.witdrawal.service.app.service.imp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.banking.witdrawal.service.app.model.Witdrawal;
import com.banking.witdrawal.service.app.repository.WitdrawalRepository;
import com.banking.witdrawal.service.app.service.WitdrawalService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class WitdrawalServiceImp implements WitdrawalService{

	private static final Logger log = LoggerFactory.getLogger(WitdrawalServiceImp.class);
	//Dependency injection required for the class work
	@Autowired
	private WitdrawalRepository witdrawalRepository;

	@Override
	public Flux<Witdrawal> findAll() {
		return witdrawalRepository.findAll();
	}

	@Override
	public Mono<Witdrawal> finById(String id) {
		return witdrawalRepository.findById(id);
	}

	@Override
	public Mono<Witdrawal> save(Witdrawal witdrawal) {
		return witdrawalRepository.save(witdrawal);
	}

	@Override
	public Mono<Void> delete(Witdrawal witdrawal) {
		return witdrawalRepository.delete(witdrawal);
	}

	@Override
	public Flux<Witdrawal> findByAccountId(String accountId) {
		return witdrawalRepository.findByAccountId(accountId)
				.defaultIfEmpty(new Witdrawal())
				.flatMap(_witdrawal -> _witdrawal.getId() == null ?
						Mono.error(new InterruptedException("Not found")):
						Mono.just(_witdrawal)
				)
				.onErrorResume(_ex ->{
					log.error(_ex.getMessage());
					return Mono.empty();
				});
	}
	
}
