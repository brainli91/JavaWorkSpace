package com.fdmgroup.fileiotddwalthrough.fileio;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;

public class BufferedWriterFactory {
	private WriterFactory writerFactory;
	
	public BufferedWriterFactory (WriterFactory writerFactory) {
		this.writerFactory = writerFactory;
	}
	
	public BufferedWriter createBufferedWriter() throws IOException{
		Writer writer = writerFactory.createWriter();
		BufferedWriter bufferedWriter = new BufferedWriter(writer);
		return bufferedWriter;
	}
}
