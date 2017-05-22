package com.fdmgroup.bankdesign;
import java.math.BigDecimal;

public class CheckingAccount extends Account implements BusinessAccount, PersonalAccount {
	
	private int INITIAL_CHECKINGNUMBER = 1;
	private int checkNumber = INITIAL_CHECKINGNUMBER;
	private int nextCheck = INITIAL_CHECKINGNUMBER + 1;
	
	protected CheckingAccount(int customerId, int accountId, BigDecimal balance) {
		super(customerId, accountId, balance);
	}
	
	public int getCheckNumber() {
		return checkNumber;
	}
	
	public int getNextCheck() {
		return nextCheck;
	}
	
	public int requestCheck(int amount) {
		int currentNum = this.nextCheck;
		this.nextCheck += amount;
		return currentNum;
	}

	@Override
	public void withdrawMoney(BigDecimal balance) {
		this.setBalance(this.getBalance().subtract(balance));
	}

	@Override
	public void depositMoney(BigDecimal balance) {
		this.setBalance(this.getBalance().add(balance));
	}

	@Override
	public void setInterestRate(Number amount) {
		// TODO Auto-generated method stub
		
	}

	
}