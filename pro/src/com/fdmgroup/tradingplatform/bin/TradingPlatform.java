package com.fdmgroup.tradingplatform.bin;

import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.fdmgroup.tradingplatform.dao.CompanyRAMDAO;
import com.fdmgroup.tradingplatform.dao.CurrentShareholderSharesRAMDAO;
import com.fdmgroup.tradingplatform.dao.LogRAMDAO;
import com.fdmgroup.tradingplatform.dao.PersonRAMDAO;
import com.fdmgroup.tradingplatform.dao.RequestRAMDAO;
import com.fdmgroup.tradingplatform.dao.RoleRAMDAO;
import com.fdmgroup.tradingplatform.dao.SecurityRoleRAMDAO;
import com.fdmgroup.tradingplatform.dao.TradeRAMDAO;

public class TradingPlatform {

	private EntityManagerFactory emf;
	private LogRAMDAO logRAMDAO = new LogRAMDAO();
	private RequestRAMDAO requestRAMDAO = new RequestRAMDAO();
	private PersonRAMDAO personRAMDAO = new PersonRAMDAO();
	private TradeRAMDAO tradeRAMDAO = new TradeRAMDAO();
	private CurrentShareholderSharesRAMDAO currentShareholderSharesRAMDAO = new CurrentShareholderSharesRAMDAO();
	private SecurityRoleRAMDAO securityRoleRAMDAO = new SecurityRoleRAMDAO();
	private CompanyRAMDAO companyRAMDAO = new CompanyRAMDAO();
	private Portfolio portfolio;
	private Company company;
	private Request request;
	private Person person;
	
	private SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private List<Person> persons = new ArrayList<Person>();

	static Logger log = 
			Logger.getLogger(TradingPlatform.class);	
	
	public TradingPlatform(){	
		
		PropertyConfigurator.configure("log4j.properties");
		logRAMDAO.setEmf(emf);
		requestRAMDAO.setEmf(emf);
		personRAMDAO.setEmf(emf);
		tradeRAMDAO.setEmf(emf);
		companyRAMDAO.setEmf(emf);
	}

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	public EntityManagerFactory getEmf() {
		return emf;
	}

	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	public RequestRAMDAO getRequestRAMDAO() {
		return requestRAMDAO;
	}

	public void setRequestRAMDAO(RequestRAMDAO requestRAMDAO) {
		this.requestRAMDAO = requestRAMDAO;
	}

	public PersonRAMDAO getPersonRAMDAO() {
		return personRAMDAO;
	}

	public void setPersonRAMDAO(PersonRAMDAO personRAMDAO) {
		this.personRAMDAO = personRAMDAO;
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

	public LogRAMDAO getLogRAMDAO() {
		return logRAMDAO;
	}

	public void setLogRAMDAO(LogRAMDAO logRAMDAO) {
		this.logRAMDAO = logRAMDAO;
	}

	public CompanyRAMDAO getCompanyRAMDAO() {
		return companyRAMDAO;
	}

	public void setCompanyRAMDAO(CompanyRAMDAO companyRAMDAO) {
		this.companyRAMDAO = companyRAMDAO;
	}

	public void setSecurityRoleRAMDAO(SecurityRoleRAMDAO securityRoleRAMDAO) {
		this.securityRoleRAMDAO = securityRoleRAMDAO;
	}

	public void loginPerson(String password, String userName){ 
		
		person = logRAMDAO.read(userName);
		if (person == null || !person.getPassword().equals(password)){
			log.error("Wrong Username or Password.");
		}
		else 
		{
		this.persons.add(person);
		log.info("User Logged. " + person);
		}
	}	
	
	public void makeRequest(Person person, int requestId, Request request, int sharesFilled,
			String buySell, String status, int companyId, int shares, int minimumShares,
			String timeInForce, BigDecimal limitPrice, BigDecimal stopPrice){
		
		company = companyRAMDAO.read(companyId);
		Set<Role> roles =  person.getRoles();
		for (Role role : roles){
			Date time = new Date();
			role.setRoleFactory(new RoleFactory());
			role.getMakeRequest().setRequestRAMDAO(requestRAMDAO);
			request = role.getMakeRequest().makeRequest(requestId, request, sharesFilled, person, time,
					buySell, status, company, shares, minimumShares, timeInForce, limitPrice, stopPrice);
			log.info("Request Made. " + person + " " + request);
		}	
	}
	
	public Portfolio viewPortfolio(Person person){
		
		Set<Role> roles =  person.getRoles();
		for (Role role : roles){
			role.setRoleFactory(new RoleFactory());
			personRAMDAO.setEmf(emf);
			requestRAMDAO.setEmf(emf);
			tradeRAMDAO.setEmf(emf);
			role.getViewPortfolio().setRequestRAMDAO(requestRAMDAO);
			role.getViewPortfolio().setPersonRAMDAO(personRAMDAO);
			role.getViewPortfolio().setTradeRAMDAO(tradeRAMDAO);		
			role.getViewPortfolio().setCurrentShareholderSharesRAMDAO(currentShareholderSharesRAMDAO);
			role.getViewPortfolio().setSecurityRoleRAMDAO(securityRoleRAMDAO);
			portfolio = role.getViewPortfolio().viewPortfolio(person.getPersonId());
			log.info("Portfolio Viewed. " + person + " " + portfolio);
		}	
		return portfolio;
	}
	
	
}
