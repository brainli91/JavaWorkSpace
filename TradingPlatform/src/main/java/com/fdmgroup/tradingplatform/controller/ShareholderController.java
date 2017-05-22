package com.fdmgroup.tradingplatform.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;


import com.fdmgroup.tradingplatform.databasedao.CompanyDAO_JDBC;
import com.fdmgroup.tradingplatform.databasedao.RequestDAO_JDBC;
import com.fdmgroup.tradingplatform.databasedao.RoleDAO_JDBC;
import com.fdmgroup.tradingplatform.databasedao.TradeDAO_JDBC;
import com.fdmgroup.tradingplatform.databasedao.UserDAO_JDBC;
import com.fdmgroup.tradingplatform.model.Company;
import com.fdmgroup.tradingplatform.model.Request;
import com.fdmgroup.tradingplatform.model.Role;
import com.fdmgroup.tradingplatform.model.Trade;
import com.fdmgroup.tradingplatform.model.User;

public class ShareholderController {

	private CompanyDAO_JDBC companyDAO = CompanyDAO_JDBC
			.getInstance();
	private RequestDAO_JDBC requestDAO = RequestDAO_JDBC
			.getInstance();
	private TradeDAO_JDBC tradeDAO = TradeDAO_JDBC.getInstance();
	private UserDAO_JDBC userDAO = UserDAO_JDBC.getInstance();
	private RoleDAO_JDBC roleDAO = RoleDAO_JDBC.getInstance();
	public String profile(String userName) {
		User targetUser = userDAO.findByUserName(userName);
		String secondRole = "";

		String info = "***************** PROFILE ******************\nUsername: "
				+ targetUser.getUserName() + "\nName: "
				+ targetUser.getFirstName() + " " + targetUser.getLastName()
				+ "\nRole: "
				+ targetUser.getRoles().get(0).getName();
		if (targetUser.getRoles().size() == 2) {
			secondRole = targetUser.getRoles().get(1).getName()
					.toUpperCase();
		}
		info = info.toUpperCase()+" " + secondRole.toUpperCase();
		System.out.println(info);
		return info;
	}

	public boolean changeProfile(String userName, String fname, String lname, List<String> roles) {
		User persistentUser = userDAO.findByUserName(userName);

		if (persistentUser == null) {
			System.out.println("User could not be found. Please try again");
		} else {
			persistentUser.setFirstName(fname);
			persistentUser.setLastName(lname);
			
			List<Role> listRoles = new ArrayList<Role>();
			
			for (String name : roles) {
				Role foundRole = roleDAO.findRoleByRoleName(name);

				if (foundRole != null) {
					listRoles.add(foundRole);
				}
			}


			persistentUser.setRoles(listRoles);

			persistentUser = userDAO.update(persistentUser);
		}
		if (persistentUser == null) {
			System.out
					.println("Error occurred while processing your request.Please try again.");
			return false;
			
		} else {
			System.out.println("Successfully updated user profile");
			return true;
		}

	}

	public HashMap<Integer, Integer> showPortfolio(String userName) {
		User loggedInUser = userDAO.findByUserName(userName);
		loggedInUser.setPortfolio(tradeDAO.portfolioForUser(userName));
		System.out.println("*******************PORTFOLIO*****************");
		for (Integer key : loggedInUser.getPortfolio().keySet()) {
			System.out.println(companyDAO.findByStockId(key).getName() + " : "
					+ loggedInUser.getPortfolio().get(key));

		}

		return null;

	}

	public ShareholderController() {
		super();
	}
	public boolean buy(String userName, String companyName, Integer shareCount) {
		Request buyRequest = new Request();
		
		buyRequest.setCompany(companyDAO.findByName(companyName));
		buyRequest.setRequestDate(new Date(Calendar.getInstance().getTime()
				.getTime()));
		buyRequest.setShareholder(userDAO.findByUserName(userName));
		buyRequest.setShareCount(shareCount);
		buyRequest.setMinShares(0);
		buyRequest.setTimeInForce("GOOD UNTIL CANCELLED");
		buyRequest.setStatus("ACTIVE");
		buyRequest.setType("BUY");
		
		
		if (requestDAO.create(buyRequest) != null) {
			requestDAO.processRequest();
			System.out.println("Request Sent.");
			showPortfolio(userName);
			return true;
		} else {
			System.out
			.println("An error occurred while processing your request. Please try again.");
			return false;
		}
	}

	public boolean sell(String userName, String companyName, Integer shareCount) {
		Request sellRequest = new Request();
		sellRequest.setCompany(companyDAO.findByName(companyName));
		sellRequest.setRequestDate(new Date(Calendar.getInstance().getTime()
				.getTime()));
		sellRequest.setShareholder(userDAO.findByUserName(userName));
		sellRequest.setShareCount(shareCount);
		sellRequest.setMinShares(0);
		sellRequest.setTimeInForce("GOOD UNTIL CANCELLED");
		sellRequest.setStatus("ACTIVE");
		sellRequest.setType("SELL");

		if (requestDAO.create(sellRequest) != null) {
			System.out.println("Request Sent.");
			requestDAO.processRequest();
			showPortfolio(userName);
			return true;
			
		} else {
			System.out
			.println("An error occurred while processing your request. Please try again.");
			return false;
		}
		
	}

	public void requestsHistoryView(String userName) {
		List<Request> requests = requestDAO.findRequestByUserName(userName);
		if (requests == null) {
			System.out
					.println("An error occurred while processing your request. Please try again.");
		}
		for (Request request : requests) {
			System.out.println(request.toString());
		}
	}

	public void tradeHistoryView(String userName) {
		List<Trade> trades = tradeDAO.findTradeByUserName(userName);
		if (trades == null) {
			System.out
					.println("An error occurred while processing your request. Please try again.");
		}
		for (Trade trade : trades) {
			System.out.println(trade.toString());
		}
	}


}
