package com.fdmgroup.tradingplatform.view;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.fdmgroup.tradingplatform.controller.ShareholderController;
import com.fdmgroup.tradingplatform.dao.CollectionCompanyDAO;
import com.fdmgroup.tradingplatform.dao.CollectionRequestDAO;
import com.fdmgroup.tradingplatform.dao.CollectionTradeDAO;
import com.fdmgroup.tradingplatform.dao.CollectionUserDAO;
import com.fdmgroup.tradingplatform.model.Company;
import com.fdmgroup.tradingplatform.model.Request;
import com.fdmgroup.tradingplatform.model.Role;
import com.fdmgroup.tradingplatform.model.Trade;
import com.fdmgroup.tradingplatform.model.User;


public class Main {
	
	public static void main(String[] args) {
		Role role1 = new Role (2,"Shareholder");
		ShareholderController sh = new ShareholderController();
		List<Role> r = new ArrayList<Role>();
		r.add(role1);
		User us = new User(1,"martin123", "Martin", "Ogor", "mo1234", null);
		User us2 = new User(2,"lisibo", "Brian", "Li", "sli106", r);
		
		CollectionUserDAO userdao = CollectionUserDAO.getInstance();
		CollectionCompanyDAO companydao = CollectionCompanyDAO.getInstance();
		CollectionRequestDAO requestdao = CollectionRequestDAO.getInstance();
		CollectionTradeDAO tradedao = CollectionTradeDAO.getInstance();
		
		
		Date transactionTime = new Date(2016,04,25);
		Company company = new Company( "Apple", 120.12);
		companydao.create(company);
		Request buyRequest = new Request(null, 100, us, transactionTime, "BUY", "Active", company, 100, 100, "GOOD UNTIL CANCELLED", null, null);
		requestdao.create(buyRequest);
		Trade tr = new Trade(company, transactionTime, 100, 5.09, 20000.00, us, null, buyRequest, null);
		tradedao.create(tr);
		
		
		Request sellRequest = new Request(null, 60, us, transactionTime, "SELL", "Active", company, 60, 60, "GOOD UNTIL CANCELLED", null, null);
		requestdao.create(buyRequest);
		Trade trsell = new Trade(company, transactionTime, 60, 5.09, 20000.00, us, null, null, sellRequest);
		tradedao.create(trsell);
		
		userdao.create(us);
		String pro = sh.profile("martin123");
		System.out.println(pro);
		
		sh.showPortfolio(us.getUserName());
		
		List<String> r2 = new ArrayList<String>();
		r2.add("Shareholder");
		sh.changeProfile(us2.getFirstName(), us2.getLastName(), us2.getPassWord(),r2);
		
		
	}


	

}
