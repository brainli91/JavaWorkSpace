package com.fdmgroup.factory;

import jpa.Request_DAO_JPA;
import jpa.Trade_DAO_JPA;
import jpa.User_DAO_JPA;
import dao.IStorage;

public class DAOFactory {
	
	public enum daoType{
		USERDAO, REQUESTDAO, TRADEDAO;	
		}
	
	public static IStorage<?,?,?> daoFactory(daoType input){
		IStorage<?,?,?> dao = null;
		
		if(input == daoType.USERDAO){
			dao = new User_DAO_JPA();
		}
		if(input == daoType.REQUESTDAO){
			dao = new Request_DAO_JPA();
		}
		if(input == daoType.TRADEDAO){
			dao = new Trade_DAO_JPA();
		}
		
		return dao;
		
	}

}


