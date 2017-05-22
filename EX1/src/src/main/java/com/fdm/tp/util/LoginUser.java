package com.fdm.tp.util;

import com.fdm.tp.model.storable.User;


public class LoginUser implements IActions{
	

	

	public int login(User user){
		
		
		
		return user.getRole();
	}

	public int executeAction(User user) {
		// TODO Auto-generated method stub
		return login(user); 
	}
}
