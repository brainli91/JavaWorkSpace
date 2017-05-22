package com.fdmgroup.fileiotddwalthrough.fileio;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import java.io.IOException;
import java.io.Writer;

import org.junit.Before;
import org.junit.Test;

public class WriterFactoryTest {
	private WriterFactory writerFactory;
	
	@Before
	public void setup() throws IOException {
		writerFactory = new WriterFactory(anyString());
	}
	
	@Test
	public void test_createWriter_returnWriter() throws IOException {
		// A
		// A
		Writer writer = writerFactory.createWriter();
		// A
		assertTrue(writer instanceof Writer);
	}

}
