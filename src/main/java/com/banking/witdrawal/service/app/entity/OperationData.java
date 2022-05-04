package com.banking.witdrawal.service.app.entity;

import lombok.Data;

@Data
public class OperationData {
	
	private String accountId;
	private String customerId; 
	private Double accountChange; 
	private Integer operation; 
	private String destinyAccountId; 
	private String destinyCustomerId;
	
}
