package com.fdmgroup.tradingplatform.bin;

import com.fdmgroup.tradingplatform.interfaces.AddUser;
import com.fdmgroup.tradingplatform.interfaces.AdministratorViewPortfolio;
import com.fdmgroup.tradingplatform.interfaces.MakeRequest;
import com.fdmgroup.tradingplatform.interfaces.OtherRequest;
import com.fdmgroup.tradingplatform.interfaces.OtherViewPortfolio;
import com.fdmgroup.tradingplatform.interfaces.ShareholderRequest;
import com.fdmgroup.tradingplatform.interfaces.ViewPortfolio;

public class RoleFactory {

	private MakeRequest makeRequest;
	private ViewPortfolio viewPortfolio;
	private AddUser addUser;
	
	public MakeRequest createRequest(String type){
		if (type.equals("Shareholder")){
			makeRequest = new ShareholderRequest();
		}
		else{
			makeRequest = new OtherRequest();
		}
		return makeRequest;
	}
	
	public ViewPortfolio createPortfolio(String type){
		
		if (type.equals("Administrator")){
			viewPortfolio = new AdministratorViewPortfolio();
		}
		else{
			viewPortfolio = new OtherViewPortfolio();
		}
		return viewPortfolio;

	}
	
	public AddUser createUser(String type){
		return null;
	}
	
	
}

