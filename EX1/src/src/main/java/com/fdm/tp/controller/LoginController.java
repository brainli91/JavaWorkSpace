package com.fdm.tp.controller;

import com.fdm.exceptions.LoginException;
import com.fdm.tp.model.storable.User;
import com.fdm.tp.util.IActions;
import com.fdm.tp.validate.ILoginValidator;
import com.fdm.tp.view.IView;
import com.fdm.tp.view.LoginView;


public class LoginController implements IController{
	private IView view;
	private ILoginValidator loginVal;
	private IActions login;

	LoginController(IView view, ILoginValidator loginVal, IActions login) {
		this.view = view;  
		this.loginVal = loginVal;
		this.login = login;
	}
 
	public int handle() {
		// TODO Auto-generated method stub
		User user = view.getUser();
		try {
			loginVal.validate(user);
			return login.executeAction(user);	
		} catch (LoginException e) {
			e.printStackTrace();
		}
		return IController.login;
		
	}

}
