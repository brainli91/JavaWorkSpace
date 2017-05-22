package com.fdm.tp.controller;

import java.util.Scanner;

import com.fdm.tp.view.LoginView;
import com.fdm.tp.view.View;


public class ControllerFactory {
		
		/**
		 * returns creates different controller objects depending on the type number
		 * @param type
		 * @return
		 */
	  public static  IController create(int type) {
	       switch (type) {
	           case IController.start:
	              return new StartController(null);
	           case IController.register:
	               return new RegistrationController(null, null, null);
	           case IController.login:
	              return new LoginController(new LoginView(), null, null);
	           default:
	              throw new IllegalArgumentException("Incorrect type code value");
	       }
	   }
	
}
