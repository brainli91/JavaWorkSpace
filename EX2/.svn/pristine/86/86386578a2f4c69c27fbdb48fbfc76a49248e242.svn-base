package tests;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import jpa.Company_DAO_JPA;

import org.junit.Before;
import org.junit.Test;

import entities.Company;
import exceptions.StorableNotFoundException;

public class Company_DAO_JPA_TEST {
	
	Company_DAO_JPA dao = new Company_DAO_JPA();
	Company company1 = new Company();
	Company company2 = new Company();


	
	@Before
	public void setUp(){
		company1.setCompanyId(10);
		company1.setName("Wayne Enterprises");
		company1.setStartingPrice(new BigDecimal(500));
		company1.setStockId(new BigDecimal(10));
		
		company2.setName("Daily Planet");
		company2.setStartingPrice(new BigDecimal(50));
		company2.setStockId(new BigDecimal(50));
		
	}
	
//	@Test
//	public void testCreate(){
//		try {
//			dao.create(company1);
//		} catch (StorableNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	public void testRead(){
//		try {
//			assertTrue(dao.read(1).getStockId()==2);
//		} catch (StorableNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	@Test
//	(expected=StorableNotFoundException.class)
//	public void testReadThrowsException() throws StorableNotFoundException{
//		dao.read(50);
//	}
//	
//	@Test
//	public void testUpdate(){
//		try {
//			dao.update(company1, company2);
//			assertTrue(dao.read(10).getName().equals("Daily Planet"));
//		} catch (StorableNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}		
//	}
	
//	@Test
//	public void testDelete(){
//		try {
//			dao.delete(10);
//		} catch (StorableNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	(expected=StorableNotFoundException.class)
//	public void testDeleteThrowsException() throws StorableNotFoundException{
//		
//			dao.delete(10);
//		
//	}
	
	

}
