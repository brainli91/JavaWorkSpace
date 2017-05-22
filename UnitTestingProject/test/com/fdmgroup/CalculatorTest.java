package com.fdmgroup;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
 
public class CalculatorTest {
	
	private Point p1 =null;
	private Point p2 =null;
	private Calculator calc =null;
	
	
	@Before
	public void setUp(){
		p1 =new Point(10,20);
		p2 =new Point(45,80);
		calc = new Calculator();

		
	}
	
	@Test
	public void testCalculateDistance(){
		calc.calculateDistance(p1,p2);
		assertEquals(69.4622,calc.calculateDistance(p1,p2), 0.0001);
		fail("No impletations yes.");
	}

}
