package com.banking.witdrawal.service.app.model;

import java.time.LocalDate;
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
	private Boolean fromCard;
	private Long cardNumber;
	//account number to withdraw
	private Long numAccount;
	//amount to withdraw
	private Double amountWithdraw;
	//verification pin
	private String password;
	//Withdrawal status approved or rejected
	private Integer status;
	// Date operation
	private LocalDate operationDate = LocalDate.now();
}
