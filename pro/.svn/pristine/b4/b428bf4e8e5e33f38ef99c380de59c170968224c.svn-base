package com.fdmgroup.tradingplatform.interfaces;

import java.math.BigDecimal;
import java.util.Date;

import com.fdmgroup.tradingplatform.bin.Company;
import com.fdmgroup.tradingplatform.bin.Person;
import com.fdmgroup.tradingplatform.bin.Request;
import com.fdmgroup.tradingplatform.dao.RequestRAMDAO;

public interface MakeRequest {
	
	Request makeRequest(int requestId, Request request, int sharesFilled, Person person,
			Date time, String buySell, String status, Company company, int shares,
			int minimumShares, String timeInForce, BigDecimal limitPrice, BigDecimal stopPrice);
	
	void setRequestRAMDAO(RequestRAMDAO requestRAMDAO);

	
}
