package com.banking.witdrawal.service.app.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "witdrawals")
public class Witdrawal {
	
	@Id
	private String id;
	//account number to withdraw
	private Long numAccount;
	//amount to withdraw
	private Long amountWithdraw;
	//verification pin
	private String password;
	//Dollar or soles
	private int moneyType;
	//Witdrawal status approved or rejected
	private int status;
	// Date operation
	private Date operationDate;
}
