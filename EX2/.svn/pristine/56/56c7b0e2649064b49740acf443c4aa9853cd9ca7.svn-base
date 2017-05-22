package tests;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.sql.Date;

import jpa.Trade_DAO_JPA;

import org.junit.Before;
import org.junit.Test;

import entities.Person;
import entities.Request;
import entities.Trade;
import exceptions.StorableNotFoundException;

public class Trade_DAO_JPA_Test {
	
	Trade_DAO_JPA dao = new Trade_DAO_JPA();
	Trade trade = new Trade();
	Trade trade2 = new Trade();
	Person person = new Person();
	Request request = new Request();

	@Before
	public void setUp(){
		person.setPersonId(11);
		request.setRequestId(1);
		
		trade.setPriceTotal(new BigDecimal(100));
		trade.setSharePrice(new BigDecimal(50));
		trade.setShares(new BigDecimal(20));
		trade.setStockId(new BigDecimal(3));
		trade.setTradeId(2);
		trade.setTransactionTime(new Date(10-11-12));
		trade.setPerson1(person);
		trade.setPerson2(person);
		trade.setRequest1(request);
		trade.setRequest2(request);
		
		trade2.setPriceTotal(new BigDecimal(1800));
		trade2.setSharePrice(new BigDecimal(570));
		trade2.setShares(new BigDecimal(570));
		trade2.setStockId(new BigDecimal(3));
		trade2.setTradeId(2);
		trade2.setTransactionTime(new Date(10-11-15));
		trade2.setPerson1(person);
		trade2.setPerson2(person);
		trade2.setRequest1(request);
		trade2.setRequest2(request);
	}
	
//	@Test
//	public void testCreate(){
//		try {
//			dao.create(trade);
//		} catch (StorableNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	(expected=StorableNotFoundException.class)
//	public void testCreateThrowsException() throws StorableNotFoundException{
//		dao.create(null);
//	}
	/*******************************************************************************************************/
	
//	@Test
//	public void testRead(){
//		try {
//			assertTrue(dao.read(2).getStockId().equals(3));
//		} catch (StorableNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	(expected=StorableNotFoundException.class)
//	public void testReadThrowsException() throws StorableNotFoundException{
//		dao.read(565);
//	}
//	
//	@Test
//	public void testUpdate(){
//		try {
//			dao.update(trade, trade2);
//		} catch (StorableNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	/****************************************************************************************/
//	@Test 
//	public void testDelete(){
//		try {
//			dao.delete(2);
//		} catch (StorableNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
//	@Test 
//	(expected=StorableNotFoundException.class)
//	public void testDeleteThrowsException() throws StorableNotFoundException{
//		dao.delete(45);
//	}

}
