package com.fdmgroup;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class BasketTest {
	
	private Book book1;
	private Book book2;
	private Basket bask;
	
	@Before
	public void setUp(){
		bask = new Basket();
		book1 = new Book("Head First Java");
		book2 = new Book("TDD Exercise Book");
	}

	@Test

	public void test_GetBooksInBasket_ReturnsEmptyBookList_IfNoBooksHaveBeenAdded(){
		assertEquals(0, bask.size());
	}
	
	@Test
	public void test_GetBooksInBasket_ReturnsArrayOfLengthOne_afterAddBookMethodIsCalledWithOneBook(){
		bask.addBook(book1);
		bask.getBooksInBasket();
		assertEquals(1,bask.size());
	}

	@Test
	public void test_GetBooksInBasket_ReturnsArrayOfLengthTwo_afterAddBookMethodIsCalledWithTwoBook(){
		bask.addBook(book1);
		bask.addBook(book2);
		bask.getBooksInBasket();
		assertEquals(2,bask.size());
	}
	

}
