package com.fdmgroup.tradingplatform.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.fdmgroup.tradingplatform.dao.CollectionCompanyDAO;
import com.fdmgroup.tradingplatform.dao.CollectionRequestDAO;
import com.fdmgroup.tradingplatform.dao.CollectionRoleDAO;
import com.fdmgroup.tradingplatform.dao.CollectionUserDAO;
import com.fdmgroup.tradingplatform.databasedao.CompanyDAO_JDBC;
import com.fdmgroup.tradingplatform.databasedao.RequestDAO_JDBC;
import com.fdmgroup.tradingplatform.databasedao.RoleDAO_JDBC;
import com.fdmgroup.tradingplatform.databasedao.UserDAO_JDBC;
import com.fdmgroup.tradingplatform.model.Company;
import com.fdmgroup.tradingplatform.model.Request;
import com.fdmgroup.tradingplatform.model.Role;
import com.fdmgroup.tradingplatform.model.User;

public class BrokerController {

	private CompanyDAO_JDBC companyDAO = CompanyDAO_JDBC.getInstance();
	private UserDAO_JDBC userDAO = UserDAO_JDBC.getInstance();
	private RoleDAO_JDBC roleDAO = RoleDAO_JDBC.getInstance();
	private RequestDAO_JDBC requestDAO = RequestDAO_JDBC.getInstance();

	public List<Company> brokerCompanyList() {
		List<Company> companies = companyDAO.readAll();
		if (companies == null) {
			System.out.println("An error occurred while processing your request. Please try again.");
		}

		else {
			for (Company company : companies) {
				System.out.println("Company ID " + company.getId() + " Stock ID " + company.getStockId()
						+ " Company Name " + company.getName() + " Starting Price " + company.getStartingPrice());
			}
		}
		return companies;
	}

	public boolean brokerUpdateCompany(String oldName, String newName, Double startingPrice) {
		Company updatedCompany = companyDAO.findByName(oldName);
		if (updatedCompany == null) {
			System.out.println("Company not found!");
		}

		updatedCompany.setName(newName);
		updatedCompany.setStartingPrice(startingPrice);
		if (companyDAO.update(updatedCompany) == null) {
			System.out.println("An error occured while processing your request. Please try again.");
			return false;
		} else {

			System.out.println("Successfully created company" + updatedCompany.getName());
			brokerCompanyList();
			return true;
		}

		

	}

	public Company brokerAddCompany(String coName, Double startingPrice, Integer initialAuthorizedShareCount) {

		Company existingCompany = companyDAO.findByName(coName);
		if (existingCompany != null) {
			System.out.println("Company named " + existingCompany.getName() + " already exists.");
		}
		Company company = new Company(coName, startingPrice);
		Company createdCompany = companyDAO.create(company);

		if (createdCompany == null) {
			System.out.println("Failure creating New Company");
			return null;
		}

		// Need to create a new user with the company role for new company//

		User newCompanyUser = new User();
		newCompanyUser.setUserName(coName);
		newCompanyUser.setPassWord(coName);
		newCompanyUser.setFirstName(coName);
		newCompanyUser.setLastName(coName);
		List<Role> listRoles = new ArrayList<Role>();
		Role companyRole = roleDAO.findRoleByRoleName("Company");
		listRoles.add(companyRole);
		newCompanyUser.setRoles(listRoles);
		User newCreatedCompanyUser = userDAO.create(newCompanyUser);
		if (newCreatedCompanyUser == null) {
			System.out.println("Failure creating user associated with new company");

		}

		// Need to create a new request to sell the new company's initial
		// shares, if any:
		if (initialAuthorizedShareCount != 0) {
			Request newCompanySellRequest = new Request();
			newCompanySellRequest.setCompany(createdCompany);
			newCompanySellRequest.setMinShares(0);
			newCompanySellRequest.setRequestDate(new Date(Calendar.getInstance().getTime().getTime()));
			newCompanySellRequest.setShareholder(newCompanyUser);
			newCompanySellRequest.setShareCount(initialAuthorizedShareCount);
			newCompanySellRequest.setSharesFilled(0);
			newCompanySellRequest.setStatus("ACTIVE");
			newCompanySellRequest.setTimeInForce("GOOD UNTIL CANCELLED");
			newCompanySellRequest.setType("SELL");
			if (requestDAO.create(newCompanySellRequest) == null) {
				System.out.println("Failure creating request to sell company initial shares.");
			}
		}
		System.out.println("Company created successfully!");
		return createdCompany;

	}

	public boolean brokerDeleteCompany(String companyName) {
		Company targetCompany = companyDAO.findByName(companyName);

		if (targetCompany == null) {
			System.out.println("Company not found");
		}
		boolean deleted = companyDAO.delete(targetCompany);
		if (!deleted) {
			System.out.println("An error occured while processing your request. Please try again");
			return false;
		} else {
			System.out.println("Company deleted successfully");
			return true;
		}

	}

}