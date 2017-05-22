package com.fdmgroup;


import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CatalogueTest
{
	static ReadItemCommand mockReadItemCommand;
	static Catalogue catalogue;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		catalogue = new Catalogue();
		mockReadItemCommand = mock(ReadItemCommand.class);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception
	{
	}

	@Before
	public void setUp() throws Exception
	{
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void test_GetAllBooks_ReturnsEmptyBookList_IfNoBooksAreInTheCatalogue()
	{
		//Arrange
		ReadItemCommand mockRead = mock(ReadItemCommand.class);

		//Act
		ArrayList<Book> bookList = catalogue.getAllBooks(mockRead);
		//Assert
		assertTrue(bookList.size() == 0);
	}
	
	@Test
	public void test_GetAllBooks_CallsReadAllMethodOfReadItemCommand_WhenCalled()
	{
		//Arrange
		ReadItemCommand readItem = mock(ReadItemCommand.class);
		catalogue = new Catalogue((WriteItemCommand) readItem);
		//Act
		catalogue.getAllBooks(readItem);
		//Assert
		verify(readItem).ReadAllBooks();
	}

	@Test
	public void test_GetAllBooks_ReturnsListOfBooksItReceivesFromReadAllMethodOfReadItemCommand_WhenCalled()
	{
		//Mocks
		Book book = mock(Book.class);
		ArrayList<Book> bookList = new ArrayList<Book>();
		bookList.add(book);
		ReadItemCommand mockRead = mock(ReadItemCommand.class);
		//Stubbing
		when(mockRead.ReadAllBooks()).thenReturn(bookList);
		//Arrange
		catalogue = new Catalogue((WriteItemCommand) mockRead);
		//Act
		ArrayList<Book> books = catalogue.getAllBooks(mockRead);
		//Assert
		verify(mockRead).ReadAllBooks();
		assertTrue(books == bookList);
	}
	
	@Test
	public void test_AddBook_CallsInsertItemMethodOfWriteItemCommand_WhenCalled()
	{
		//Mocks
		Book book = mock(Book.class);
		ArrayList<Book> bookList = new ArrayList<Book>();
		bookList.add(book);
		WriteItemCommand mockWrite = mock(WriteItemCommand.class);
		//Stubbing
		//Arrange
		catalogue = new Catalogue(mockWrite);
		//Act
		catalogue.addBook();
		//Assert
		verify(mockWrite).insertItem();
	}
	
	@Test
	public void test5()
	{
		//Mocks
		Book book = mock(Book.class);
		WriteItemCommand mockWrite = mock(WriteItemCommand.class);
		//Stubbing
		//Arrange
		catalogue = new Catalogue(mockWrite);
		//Act
		catalogue.addBook();
		//Assert
		verify(mockWrite).insertItem();
		
		String string1 = new String("Hello");
		String string2 = new String("Hello");
		
		System.out.println(string1.equals(string2));
	}
}
