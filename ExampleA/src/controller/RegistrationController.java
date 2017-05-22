package com.fdm.tp.controller;

import com.fdm.exceptions.RegistrationException;
import com.fdm.tp.model.storable.User;

import com.fdm.tp.util.IActions;
import com.fdm.tp.validate.IValidator;
import com.fdm.tp.view.View;

public class RegistrationController implements IController{

	private View view;
	private IValidator regVal;
	private IActions register;

	public RegistrationController(View view, IValidator regVal, IActions register) {
		this.view = view;  
		this.regVal = regVal;
		this.register = register;
	}
	
	/**
	 * 
	 */
	public int handle() {
		// TODO Auto-generated method stub
		User user = view.getUser();
		try {
			regVal.validate(user);
			return register.executeAction(user);	
		} catch (RegistrationException e) {	
			e.printStackTrace();
		}
		return IController.register;
		
	}
	
}
