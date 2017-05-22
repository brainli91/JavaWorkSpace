package com.fdm.tp.util;

import com.fdm.tp.controller.IController;
import com.fdm.tp.model.storable.User;
import com.fdm.tp.model.storage.IStorage;

public class Action_RegisterUser implements IActions{

	private IStorage str;
	public Action_RegisterUser(IStorage str) {
		this.str = str;
	}
	
	//returns 0 if the user has been stored successfully and returns -1 when the user has not been stored
	public int register(User user) {
		str.addUser(user);
		System.out.println("user has been added"); //remove later or use as log info
		return IController.login;
	}

	public int executeAction(User user) {
		return register(user);
	}
	
}
