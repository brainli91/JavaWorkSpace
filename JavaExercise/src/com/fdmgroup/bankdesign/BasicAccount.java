package com.fdmgroup.bankdesign;

import java.math.BigDecimal;

public interface BasicAccount {
	
	public int getCustomerId();
	
	public int getAccountId();
	
	public BigDecimal getBalance();
	
	public void setBalance(BigDecimal balance);

	public void withdrawMoney(BigDecimal amount);

	public void depositMoney(BigDecimal amount);

	public int requestCheck(int amount);

	public void setInterestRate(Number amount);
	
}