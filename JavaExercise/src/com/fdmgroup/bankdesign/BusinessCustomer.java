package com.fdmgroup.bankdesign;

import java.math.BigDecimal;

public class BusinessCustomer extends Customer implements Company, Person {

	protected BusinessCustomer(int customerId, String name, String address, String taxId) {
		super(customerId, name, address, taxId);
	}

	@Override
	public void depositAllAcounts(Bank bank, BigDecimal amount) {
		for (int accountId : this.getAccountIds() ){
			bank.getAccounts().get(accountId).setBalance(bank.getAccounts().get(accountId).getBalance().add(amount));
		}
	}

	@Override
	public void resetAllAccounts(Bank bank) {
		// TODO Auto-generated method stub
		
	}


}
