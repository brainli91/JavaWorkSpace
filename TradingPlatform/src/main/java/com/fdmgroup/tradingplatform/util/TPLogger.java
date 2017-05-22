package com.fdmgroup.tradingplatform.util;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class TPLogger {
	
	private static Logger sysLogger= null;
	private static Logger userLogger= null;
	
	private TPLogger(){
	}
	
	public static Logger getSystemLogger(){
		if (sysLogger == null){
			PropertyConfigurator.configure("log4j.properties");
			sysLogger = Logger.getLogger("SysLogger");
		}
		
		return sysLogger;
	}
	
	public static Logger getUserLogger(){
		if (userLogger == null){
			PropertyConfigurator.configure("log4j.properties");
			userLogger = Logger.getLogger("UserLogger");
		}
		
		return sysLogger;
	}
}
