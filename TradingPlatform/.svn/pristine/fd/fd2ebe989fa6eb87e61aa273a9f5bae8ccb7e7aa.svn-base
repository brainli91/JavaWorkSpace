package com.fdmgroup.tradingplatform.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.fdmgroup.tradingplatform.model.Company;
import com.fdmgroup.tradingplatform.model.Request;
import com.fdmgroup.tradingplatform.model.Role;
import com.fdmgroup.tradingplatform.model.Trade;
import com.fdmgroup.tradingplatform.model.User;

public class CollectionRequestDAO implements IRequestDAO {

	private List<Request> requests = new ArrayList<Request>();

	private static CollectionRequestDAO requestDAO = null;

	CollectionRequestDAO() {
		Request newRequest = null;
		List<Role> roles = new ArrayList<Role>();
		roles.add(new Role(2, "Shareholder"));
		roles.add(new Role(3, "Company"));
		roles.add(new Role(4, "Broker"));

		User shareholder = new User(003, "gz1", "George", "Yu", "gz123", roles);
		Company company = new Company(6, 6, "Air Canada", 790.34);
		Date requestDate = new Date(2016, 04, 25);
//		requests.add(new Request(null, 150, shareholder, requestDate, "SELL",
//				"ACTIVE", company, 2000, 2000, "GOOD UNTIL CANCELLED", null,
//				null));
	}
	
	public static CollectionRequestDAO getInstance() {
		if (requestDAO == null)
			requestDAO = new CollectionRequestDAO();

		return requestDAO;
	}
	

	public List<Request> readAll() {
		return requests;
	}

	public Request create(Request t) {
		t.setId(generateId());
		requests.add(t);
		
		return t;
	}

	private Integer generateId() {

		return requests.size() + 1;
	}

	public Request read(int id) {
		for (Request request : requests) {
			if (request.getId() == id)
				return request;
		}
		return null;
	}
	
	public Request update(Request t)  {
		if (requests.contains(t)){
			int i = requests.indexOf(t);
			requests.set(i, t);
			
			return t;
		}
		
		return null;
	}


	public boolean delete(Request t) {

		return requests.remove(t);
	}

	public boolean deleteById(int id) {
		for (Request request : requests) {
			if (request.getId() == id)
				return requests.remove(request);
		}
		return false;
	}

	public List<Request> findRequestByDate(Date date, User selectedUser) {
		List<Request> tempRequestList1 = new ArrayList<Request>();

		for (Request request : requests) {
			if (request.getRequestDate().equals(date)
					&& request.getShareholder().getUserName().equals(selectedUser.getUserName())) {
				tempRequestList1.add(request);
			}
			
		}
		return tempRequestList1;
	}

	public List<Request> findRequestByStatus(String status, User selectedUser) {
		List<Request> tempRequestList2 = new ArrayList<Request>();

		for (Request request : requests) {
			if (request.getStatus().equals(status)
					&& request.getShareholder().equals(selectedUser)) {
				tempRequestList2.add(request);
			}
			
		}
		return tempRequestList2;
	}

	public List<Request> findRequestByUserName(String userName) {
		List<Request> tempRequestList3 = new ArrayList<Request>();

		for (Request request : requests) {
			if (request.getShareholder().getUserName().equals(userName)) {
				tempRequestList3.add(request);
			}
			
		}
		return tempRequestList3;
	}

}
