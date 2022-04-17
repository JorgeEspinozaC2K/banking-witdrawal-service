package com.banking.witdrawal.service.app.servicioImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.witdrawal.service.app.model.Witdrawal;
import com.banking.witdrawal.service.app.repository.WitdrawalRepository;
import com.banking.witdrawal.service.app.service.WitdrawalService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class WitdrawalServiceImpl implements WitdrawalService{

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
	
}
