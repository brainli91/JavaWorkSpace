package com.fdmgroup.fileiotddwalthrough.fileio;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriterFactory {
	private String filename;
	
	public WriterFactory(String filename) {
		this.filename = filename;
	}
	
	public Writer createWriter() throws IOException {
		Writer writer = new FileWriter(filename, true);
		return writer;
	}
}
