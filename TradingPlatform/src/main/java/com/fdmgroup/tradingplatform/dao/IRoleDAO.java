package com.fdmgroup.tradingplatform.dao;

import java.util.List;

import com.fdmgroup.tradingplatform.model.Role;
import com.fdmgroup.tradingplatform.model.User;

public interface IRoleDAO extends IStorage<Role> {

	public List<Role> findRoleByUser(User user);

	public List<Role>  findRoleByUserName(String name);
	
	public Role findRoleByRoleName(String name);

}
