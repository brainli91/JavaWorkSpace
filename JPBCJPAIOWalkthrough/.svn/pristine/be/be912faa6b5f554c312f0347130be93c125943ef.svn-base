package com.fdmgroup.fileiotddwalthrough.fileio;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;

import org.junit.Before;
import org.junit.Test;

public class BufferedWriterFactoryTest {
	private BufferedWriterFactory bufferedWriterFactory;
	private WriterFactory mockWriterFactory;
	private Writer mockWriter;
	
	@Before
	public void setup() throws IOException {
		mockWriterFactory = mock(WriterFactory.class);
		bufferedWriterFactory = new BufferedWriterFactory(mockWriterFactory);
		mockWriter = mock(Writer.class);
		when(mockWriterFactory.createWriter()).thenReturn(mockWriter);
	}
	
	@Test
	public void test_createBufferedWriter_returnBufferedWriter() throws IOException {
		// A
		// A
		BufferedWriter bufferedWriter = bufferedWriterFactory.createBufferedWriter();
		// A
		assertTrue(bufferedWriter instanceof BufferedWriter);
	}
}
