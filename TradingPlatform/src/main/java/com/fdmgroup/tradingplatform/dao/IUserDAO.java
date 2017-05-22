package com.fdmgroup.tradingplatform.dao;

import java.util.List;

import com.fdmgroup.tradingplatform.model.Share;
import com.fdmgroup.tradingplatform.model.User;

public interface IUserDAO extends IStorage<User> {
	

	
	User findByUserName(String userName);

}
