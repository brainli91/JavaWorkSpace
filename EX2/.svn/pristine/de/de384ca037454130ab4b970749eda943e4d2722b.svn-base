package tests;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.NoResultException;

import jpa.Request_DAO_JPA;
import jpa.User_DAO_JPA;

import org.junit.Before;
import org.junit.Test;

import entities.Person;
import entities.Request;
import entities.Request.BuyOrSell;
import entities.Request.Status;
import entities.Request.timeInForce;
import exceptions.StorableNotFoundException;

public class Request_DAO_JPA_Test {
	
	Request_DAO_JPA dao = new Request_DAO_JPA();

	Request request = new Request();
	Request request2 = new Request();
	
	Person person = new Person();
	Person person2 = new Person();
	
	
	User_DAO_JPA persondao= new User_DAO_JPA();


	@Before
	public void setUp(){
		person.setPersonId(11);
		person2.setPersonId(12);
		
		request.setBuySell(BuyOrSell.BUY);
		request.setLimitPrice(new BigDecimal(200));
		request.setMinimumShares(new BigDecimal(20));
		request.setRequestDate(Calendar.getInstance().getTime());
		request.setRequestId(2);
//		request.setParentRequest(dao.read(1));
		request.setSharesFilled(new BigDecimal(50));
		request.setPerson(person);
		request.setShares(new BigDecimal(50));
		request.setStatus(Status.ACTIVE.toString());
		request.setStockId(new BigDecimal(3));
		request.setStopPrice(new BigDecimal(100));
		request.setTimeInForce(timeInForce.DAY_ONLY);
		
		request2.setBuySell(BuyOrSell.BUY);
		request2.setLimitPrice(new BigDecimal(300));
		request2.setMinimumShares(new BigDecimal(20));
		request2.setRequestDate(Calendar.getInstance().getTime());
		request2.setRequestId(1);
//		request2.setParent_request_id(3);
		request2.setSharesFilled(new BigDecimal(20));
		request2.setPerson(person2);
		request2.setShares(new BigDecimal(20));
		request2.setStatus(Status.CANCELLED.toString());
		request2.setStockId(new BigDecimal(4));
		request2.setStopPrice(new BigDecimal(100));
		request2.setTimeInForce(timeInForce.GOOD_UNTIL_CANCELLED);
		
		
	}
	
//	@Test
//	public void testCreate(){
//		try {
//			dao.create(request2);
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
//	
//	@Test
//	public void testRead(){
//		Request result;
//		try {
//			result = (Request) dao.read(1);
//			assertTrue(result.getMinimumShares().equals(new BigDecimal(20)));
//		} catch (StorableNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	public void testReadThrowsException() throws StorableNotFoundException{
//		assertTrue(dao.read(6646).equals(null));
//	}
	/*********************************************************************************/
	
//	@Test
//	public void testUpdate(){
//		try {
//			dao.update(request2, request);
//		} catch (StorableNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	(expected=StorableNotFoundException.class)
//	public  void testUpdateThrowsException() throws StorableNotFoundException{
//		dao.update(request2, null);
//	}
	
//	@Test
//	public void testDelete(){
//		
//		try {
//			dao.delete(1);
//		} catch (StorableNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
}
