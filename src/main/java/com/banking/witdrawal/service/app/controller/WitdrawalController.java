package com.banking.witdrawal.service.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.witdrawal.service.app.model.Witdrawal;
import com.banking.witdrawal.service.app.service.WitdrawalService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/witdrawal")
public class WitdrawalController {

	//Dependency injection required for the class work
	@Autowired
	private WitdrawalService witdrawalService;
	
	//This method displays all the information from the transaction database
	@GetMapping("{id}")
	public Flux<Witdrawal> index(){
	return witdrawalService.findAll();
	}
	
	//This method save or update a record from the transaction database
	@PostMapping("/save")
	public Mono<Witdrawal> save(@RequestBody Witdrawal witdrawal){
		return witdrawalService.save(witdrawal);
	}
		
	@DeleteMapping("/delete")
	public Mono<Void> deleteWitdrawal(@RequestBody Witdrawal witdrawal){
		return witdrawalService.delete(witdrawal);
	}
	
}
