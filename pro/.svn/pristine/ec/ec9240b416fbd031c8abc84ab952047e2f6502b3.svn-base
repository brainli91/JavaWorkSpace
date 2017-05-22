package com.fdmgroup.tradingplatform.interfaces;

import java.math.BigDecimal;
import java.util.Date;

import com.fdmgroup.tradingplatform.bin.Company;
import com.fdmgroup.tradingplatform.bin.Person;
import com.fdmgroup.tradingplatform.bin.Request;
import com.fdmgroup.tradingplatform.dao.RequestRAMDAO;

public class ShareholderRequest implements MakeRequest {

	private int DEFALUT_REQUEST_ID = -1;
	private Request DEFALUT_PARENT_REQUEST = null;
	private int DEFALUT_SHARES_FILLED = 0;
	private RequestRAMDAO requestRAMDAO = new RequestRAMDAO();
	
	@Override
	public Request makeRequest(int requestId, Request request, int sharesFilled, Person person,
			Date requestDate, String buySell, String status, Company company, int shares,
			int minimumShares, String timeInForce, BigDecimal limitPrice, BigDecimal stopPrice) {
		
		Request newRequest = new Request( DEFALUT_PARENT_REQUEST, DEFALUT_SHARES_FILLED,
				person, requestDate, buySell, status,
				 company, shares, minimumShares, timeInForce, limitPrice, stopPrice);
		
		requestRAMDAO.create(newRequest);
		return newRequest;
	}

	public int getDEFALUT_REQUEST_ID() {
		return DEFALUT_REQUEST_ID;
	}

	public void setDEFALUT_REQUEST_ID(int dEFALUT_REQUEST_ID) {
		DEFALUT_REQUEST_ID = dEFALUT_REQUEST_ID;
	}

	public Request getDEFALUT_PARENT_REQUEST() {
		return DEFALUT_PARENT_REQUEST;
	}

	public void setDEFALUT_PARENT_REQUEST(Request dEFALUT_PARENT_REQUEST) {
		DEFALUT_PARENT_REQUEST = dEFALUT_PARENT_REQUEST;
	}

	public int getDEFALUT_SHARES_FILLED() {
		return DEFALUT_SHARES_FILLED;
	}

	public void setDEFALUT_SHARES_FILLED(int dEFALUT_SHARES_FILLED) {
		DEFALUT_SHARES_FILLED = dEFALUT_SHARES_FILLED;
	}

	public RequestRAMDAO getRequestRAMDAO() {
		return requestRAMDAO;
	}

	public void setRequestRAMDAO(RequestRAMDAO requestRAMDAO) {
		this.requestRAMDAO = requestRAMDAO;
	}
	
}
	