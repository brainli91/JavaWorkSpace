package com.fdm.tp.model.storage;

import com.fdm.tp.model.storable.User;

public interface IStorage {
	public void addUser(User user);
	public void remove(String userName);
	public User get(String userName);
}
