package com.fdmgroup.bankdesign;

import java.math.BigDecimal;

public interface PersonalAccount extends BasicAccount {
	
	void withdrawMoney(BigDecimal balance);
	void depositMoney(BigDecimal balance);
	
}