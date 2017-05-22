package com.fdmgroup.tradingplatform.dao;

import java.util.List;
import java.sql.Date;

import com.fdmgroup.tradingplatform.model.Request;
import com.fdmgroup.tradingplatform.model.User;

public interface IRequestDAO extends IStorage<Request> {

	public List<Request> findRequestByDate(Date date, User selectedUser);

	public List<Request> findRequestByStatus(String status, User selectedUser);

	public List<Request> findRequestByUserName(String userName);
}
