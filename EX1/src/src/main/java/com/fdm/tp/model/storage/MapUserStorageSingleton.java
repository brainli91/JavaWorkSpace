package com.fdm.tp.model.storage;

import java.io.Serializable;
import java.util.Map;

import com.fdm.tp.model.storable.User;

public class MapUserStorageSingleton implements IMapuserStorage, Serializable{
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private static MapUserStorageSingleton musUser ;
	 private Map<String, User> map;
	  
	 private MapUserStorageSingleton(){}
	
	//might have to set this to static
	public static MapUserStorageSingleton getInstance(){
		if (musUser == null) {
			musUser = new MapUserStorageSingleton();
		}
		return musUser;
	}

	public void setMap(Map<String, User> map) {
		this.map = map;
	}
 
	public void addUser(User user) {
		map.put( user.getUserName() , user );
	}
																														
	public void remove(String userName) {	
		map.remove(userName);
	}

	public User get(String userName) {
		return map.get(userName);
	}
	
	/*
	@Override
	public String toString(){
		String str = getInstance().hashCode() + '@' + Integer.toHexString(hashCode());
	}
	*/

}
