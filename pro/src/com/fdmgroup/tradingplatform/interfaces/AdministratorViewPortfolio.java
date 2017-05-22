package com.fdmgroup.tradingplatform.interfaces;

import java.util.HashSet;
import java.util.Set;

import com.fdmgroup.tradingplatform.bin.CurrentShareholderShares;
import com.fdmgroup.tradingplatform.bin.Person;
import com.fdmgroup.tradingplatform.bin.Portfolio;
import com.fdmgroup.tradingplatform.bin.Request;
import com.fdmgroup.tradingplatform.bin.SecurityRole;
import com.fdmgroup.tradingplatform.bin.Trade;
import com.fdmgroup.tradingplatform.dao.CurrentShareholderSharesRAMDAO;
import com.fdmgroup.tradingplatform.dao.PersonRAMDAO;
import com.fdmgroup.tradingplatform.dao.RequestRAMDAO;
import com.fdmgroup.tradingplatform.dao.SecurityRoleRAMDAO;
import com.fdmgroup.tradingplatform.dao.TradeRAMDAO;

public class AdministratorViewPortfolio implements ViewPortfolio {


	private Portfolio portfolio;
	private Person person;
	private Set<Request> requests = new HashSet<Request>();
	private Set<Trade> trades = new HashSet<Trade>();
	private Set<CurrentShareholderShares> currentShareholderShares;
	private Set<SecurityRole> securityRoles;
	private PersonRAMDAO personRAMDAO;
	private RequestRAMDAO requestRAMDAO;
	private TradeRAMDAO tradeRAMDAO;
	private CurrentShareholderSharesRAMDAO currentShareholderSharesRAMDAO;
	private SecurityRoleRAMDAO securityRoleRAMDAO;

	@Override
	public Portfolio viewPortfolio(int personId) {
		
		person = personRAMDAO.read(personId);
		requests = requestRAMDAO.read(person);
		trades = tradeRAMDAO.read(person);
		try {
			currentShareholderShares = currentShareholderSharesRAMDAO.read(personId);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		securityRoles = securityRoleRAMDAO.read(personId);
		
		portfolio = new Portfolio(person, currentShareholderShares, securityRoles, requests, trades);
		
		return portfolio;
	}

	public PersonRAMDAO getPersonRAMDAO() {
		return personRAMDAO;
	}

	public void setPersonRAMDAO(PersonRAMDAO personRAMDAO) {
		this.personRAMDAO = personRAMDAO;
	}

	public RequestRAMDAO getRequsetRAMDAO() {
		return requestRAMDAO;
	}

	public void setRequestRAMDAO(RequestRAMDAO requsetRAMDAO) {
		this.requestRAMDAO = requsetRAMDAO;
	}

	public TradeRAMDAO getTradeRAMDAO() {
		return tradeRAMDAO;
	}

	public void setTradeRAMDAO(TradeRAMDAO tradeRAMDAO) {
		this.tradeRAMDAO = tradeRAMDAO;
	}

	public CurrentShareholderSharesRAMDAO getCurrentShareholderSharesRAMDAO() {
		return currentShareholderSharesRAMDAO;
	}

	public void setCurrentShareholderSharesRAMDAO(CurrentShareholderSharesRAMDAO currentShareholderSharesRAMDAO) {
		this.currentShareholderSharesRAMDAO = currentShareholderSharesRAMDAO;
	}

	public SecurityRoleRAMDAO getSecurityRoleRAMDAO() {
		return securityRoleRAMDAO;
	}

	public void setSecurityRoleRAMDAO(SecurityRoleRAMDAO securityRoleRAMDAO) {
		this.securityRoleRAMDAO = securityRoleRAMDAO;
	}

	
}
