package com.fdmgroup.tradingplatform.bin;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityFactory {
	
	private static EntityManagerFactory emf;
	
	private  EntityFactory () {
		
	}
	
	public static EntityManagerFactory getEmf(){
		if(emf == null){
			emf = Persistence.createEntityManagerFactory("storejpa");
		}
		return emf;
	}
	
}
