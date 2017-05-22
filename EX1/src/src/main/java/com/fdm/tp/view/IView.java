package com.fdm.tp.view;

import com.fdm.tp.model.storable.User;

public interface IView {
	
	public User getUser();
	public void displayMessage(String string);
	
}
