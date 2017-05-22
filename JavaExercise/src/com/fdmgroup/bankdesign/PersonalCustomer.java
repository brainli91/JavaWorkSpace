package com.fdmgroup.bankdesign;

import java.math.BigDecimal;

public class PersonalCustomer extends Customer implements Company, Person {
	
	protected PersonalCustomer(int customerId, String name, String address, String taxID) {
		super(customerId, name, address, taxID);
	}

	@Override
	public void resetAllAccounts(Bank bank) {
		for (int accountID : this.getAccountIds() ){
			bank.getAccounts().get(accountID).setBalance(BigDecimal.ZERO);		
		}
	}

	@Override
	public void depositAllAcounts(Bank bank, BigDecimal amount) {
		// TODO Auto-generated method stub
		
	}


	
}