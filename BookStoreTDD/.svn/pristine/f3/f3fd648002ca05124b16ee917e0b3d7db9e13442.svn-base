package com.fdmgroup;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class CheckoutTest {
	
	private Basket basket;
	private Checkout chec;
	private Book book1,book2,book3;

	
	
	@Before
	public void setUp(){
	  basket = new Basket();
	  chec = new Checkout();
	  book1 = new Book("Head First Java",19.98);
	  book2 = new Book("Head First Java Ed2",100.01);
	  book3 = new Book("Java How to Program",25.99);
	
	}
	
	@Test
	@Ignore
	public void test_CalculatePrice_ReturnsDoubleZeroPointZeroWhenPassedAnEmptyBasket(){
		chec.calculatePrice(basket);
		assertEquals(0.0, chec.calculatePrice(basket),0.1);
		
	}

	@Test
	public void test_CalculatePrice_ReturnsPriceofBookInBasket_WhenPassedBasketWithOneBook(){
		basket.addBook(book1);
		assertEquals(19.98, chec.calculatePrice(basket),0.01);
	}

	@Test
	public void test_CalculatePrice_ReturnsPriceofBookInBasket_WhenPassedBasketWithTwoBook(){
		basket.addBook(book1);
		basket.addBook(book2);
		assertEquals(119.99, chec.calculatePrice(basket),0.01);
	}
	
	@Test
	public void test_CalculatePrice_Returns1PercentDisPriceofBookInBasket_WhenPassedBasketWithThreeBook(){
		basket.addBook(book3);
		basket.addBook(book3);
		basket.addBook(book3);
		assertEquals(77.19, chec.calculatePrice(basket),0.01);
	}
	
	@Test
	public void test_CalculatePrice_Returns2PercentDisPriceofBookInBasket_WhenPassedBasketWithSevenBook(){
		basket.addBook(book3);
		basket.addBook(book3);
		basket.addBook(book3);
		basket.addBook(book3);
		basket.addBook(book3);
		basket.addBook(book3);
		basket.addBook(book3);
		assertEquals(178.29, chec.calculatePrice(basket),0.01);
	}
	
	@Test
	public void test_CalculatePrice_Returns13PercentDisPriceofBookInBasket_WhenPassedBasketWithTenBook(){
		for (int i=0;i<3;i++){
			basket.addBook(book1);
			basket.addBook(book2);
			basket.addBook(book3);
		}
		basket.addBook(book3);

		assertEquals(403.61, chec.calculatePrice(basket),0.01);
	}
	
	
}
