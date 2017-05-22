package com.fdmgroup.aspect;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;



@Aspect
public class LoggingAspect {
	
	HttpServletRequest request;
	
	
	
	
	@Pointcut("execution(* com.fdmgroup.dao.*.*(..))")   
	public void p1(){}
	
	@Pointcut("execution(* com.fdmgroup.controller.*.*(..))")   
	public void p2(){}
	
	@Pointcut("execution(* com.fdmgroup.*.*.*(..))")   
	public void p3(){}
	
	@After("p1()")
	public void logAfterDAO(JoinPoint jp){
		
		String methodName = jp.getClass().getName() +" "+jp.getSignature().getName() ;
		String args = Arrays.toString(jp.getArgs());
		
	Logger logger = Logger.getLogger("system");

	logger.info("DAO method: " + methodName + " has been executed. Arguments: "+ args );

	}
	
	@After("p2()")
	public void logAfterController(JoinPoint jp){
		
		String methodName = jp.getSignature().getName();
		String args = Arrays.toString(jp.getArgs());
	

		
	Logger logger = Logger.getLogger("user");
	logger.info( "Controller method:" + methodName + " has been executed.  Arguments: " + args);


	
	
	}
	



	
	

	
	@AfterThrowing("p3()")    
	public void insertAfterThrowing(JoinPoint jp){
		Logger logger = Logger.getLogger("system");
		String methodName = jp.getSignature().getName();
		String args = Arrays.toString(jp.getArgs());
		logger.error("Error: exception thrown: "+methodName+ " args: " + args );
	}

	
	
}
