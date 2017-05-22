package com.fdmgroup.tradingplatform.interfaces;

import com.fdmgroup.tradingplatform.bin.Portfolio;
import com.fdmgroup.tradingplatform.dao.CurrentShareholderSharesRAMDAO;
import com.fdmgroup.tradingplatform.dao.PersonRAMDAO;
import com.fdmgroup.tradingplatform.dao.RequestRAMDAO;
import com.fdmgroup.tradingplatform.dao.SecurityRoleRAMDAO;
import com.fdmgroup.tradingplatform.dao.TradeRAMDAO;

public interface ViewPortfolio {

	Portfolio viewPortfolio(int personId);
	void setPersonRAMDAO(PersonRAMDAO personRAMDAO);
	void setRequestRAMDAO(RequestRAMDAO requsetRAMDAO);
	void setTradeRAMDAO(TradeRAMDAO tradeRAMDAO);
	void setCurrentShareholderSharesRAMDAO(CurrentShareholderSharesRAMDAO currentShareholderSharesRAMDAO);
	void setSecurityRoleRAMDAO(SecurityRoleRAMDAO securityRoleRAMDAO);
	
}
