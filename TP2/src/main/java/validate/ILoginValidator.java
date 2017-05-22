package com.fdm.tp.validate;

import com.fdm.exceptions.LoginException;
import com.fdm.exceptions.RegistrationException;
import com.fdm.tp.model.storable.User;

public interface ILoginValidator{
	public void validate(User user) throws LoginException;
}
