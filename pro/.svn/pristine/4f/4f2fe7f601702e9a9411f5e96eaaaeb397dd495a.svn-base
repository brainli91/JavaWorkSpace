package com.fdmgroup.tradingplatform.interfaces;

import java.math.BigDecimal;
import java.util.Date;

import com.fdmgroup.tradingplatform.bin.Company;
import com.fdmgroup.tradingplatform.bin.Person;
import com.fdmgroup.tradingplatform.bin.Request;
import com.fdmgroup.tradingplatform.dao.RequestRAMDAO;

public class OtherRequest implements MakeRequest {

	private RequestRAMDAO requestRAMDAO = new RequestRAMDAO();
	
	@Override
	public Request makeRequest(int requestId, Request request, int sharesFilled, Person person,
			Date requestDate, String buySell, String status, Company company, int shares,
			int minimumShares, String timeInForce, BigDecimal limitPrice, BigDecimal stopPrice) {
		
		Request newRequest = new Request( request, sharesFilled,
				person, requestDate, buySell, status,
			 company, shares, minimumShares, timeInForce, limitPrice, stopPrice);
		
		requestRAMDAO.create(newRequest);
		return newRequest;
		
	}

	public RequestRAMDAO getRequestRAMDAO() {
		return requestRAMDAO;
	}

	public void setRequestRAMDAO(RequestRAMDAO requestRAMDAO) {
		this.requestRAMDAO = requestRAMDAO;
	}

	
}
