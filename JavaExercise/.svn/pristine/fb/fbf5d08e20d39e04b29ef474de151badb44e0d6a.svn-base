package com.fdmgroup.bankdesign;

import java.math.BigDecimal;

public class SavingsAccount extends Account  implements BusinessAccount, PersonalAccount {

	private Number INITIAL_INTERESTRATE = 0;
	private Number interestRate = INITIAL_INTERESTRATE;
	
	protected SavingsAccount(int customerId, int accountId, BigDecimal balance) {
		super(customerId, accountId, balance);
	}

	public Number getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(Number interestRate) {
		this.interestRate = interestRate;
	}

	@Override
	public void withdrawMoney(BigDecimal balance) {
		if (this.getBalance().subtract(balance).compareTo(BigDecimal.ZERO) >= 0){
			this.setBalance(this.getBalance().subtract(balance));			
		} 
	}

	@Override
	public void depositMoney(BigDecimal balance) {
		this.setBalance(this.getBalance().add(balance));
		
	}

	@Override
	public int requestCheck(int amount) {
		return 0;
	}


	

}
