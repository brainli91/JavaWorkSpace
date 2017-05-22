package com.fdmgroup;

//import static junit.framework.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

//new best way to call assertion
import static org.junit.Assert.*;

public class ArithmeticTest {
	Arithmetic ar;
	
	@BeforeClass
	public static void init(){
		System.out.println("Initializing testing my tests...");
		
	}

	@Before
	public void setUp(){
		System.out.println("setup my test...");
		ar = new Arithmetic();
		
	}
	
	@Test
	public void testAdd(){
		assertEquals(10,ar.add(2,8));
	}
	
	@Test/*(timeout = 20000)*/ //to test the connection b/t the machine and server /*(expected = ArithmeticException.class)*/
	public void testDiv(){
		assertEquals(0,ar.div(10,0));
	}
	
	@After
	public void tearDown(){
		System.out.println("Tear down my teate...");
		
	}
	
	@AfterClass
	public static void destory(){
		
		System.out.println("Sestroying my tests...");
	}
}
