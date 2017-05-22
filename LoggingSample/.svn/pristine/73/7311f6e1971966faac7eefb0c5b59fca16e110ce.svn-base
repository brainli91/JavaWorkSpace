package com.fdmgroup;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class Arithmetic {

	Logger arLogger = Logger.getLogger("Arithmetic");
	Logger testLogger = Logger.getLogger("Test");
	
	
	public Arithmetic() {
		super();
		PropertyConfigurator.configure("log4j.properties");
	}

	public int add(int a, int b){
		arLogger.info("Inside add metheod-->a:"+a+".b:"+b);
		testLogger.trace("Inside add metheod-->a:"+a+".b:"+b);
		return a+b;
		
	}
	
	public int sub(int a, int b){
		arLogger.info("Inside sub metheod-->a:"+a+".b:"+b);
		testLogger.trace("Inside sub metheod-->a:"+a+".b:"+b);
		return a-b;
		
	}
	
	public int mul(int a, int b){
		arLogger.info("Inside mul metheod-->a:"+a+",b:"+b);
		testLogger.trace("Inside mul metheod-->a:"+a+".b:"+b);
		return a*b;
		
	}
	
	public int div(int a, int b){
		arLogger.info("Inside div metheod-->a:"+a+".b:"+b);
		testLogger.trace("Inside div metheod-->a:"+a+".b:"+b);
		if (b != 0){
			return a / b;	
		}
		else
			arLogger.info("Inside div metheod-->a:"+a+".b:"+b);
			testLogger.trace("Inside div metheod-->a:"+a+".b:"+b);
			return 0;
		
		
	}
}