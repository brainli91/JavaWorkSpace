package com.fdmgroup.fileiotddwalthrough.fileio;

import java.io.BufferedWriter;
import java.io.IOException;

import com.fdmgroup.fileiotddwalthrough.entities.User;
import com.fdmgroup.fileiotddwalthrough.io.WriteCommand;

public class FileWriteCommand implements WriteCommand {

	private BufferedWriterFactory bufferedWriterFactory;

	public FileWriteCommand(BufferedWriterFactory bufferedWriterFactory) {
		this.bufferedWriterFactory = bufferedWriterFactory;
	}

	@Override
	public void write(User user) {
		try {
			BufferedWriter bufferedWriter = bufferedWriterFactory.createBufferedWriter();
			bufferedWriter.write(user.getUsername() + ", " + user.getPassword() + ", " + user.getRole());
			bufferedWriter.close();
		} catch (IOException e) {
			// DO SOMETHING HERE LATER
			e.printStackTrace();
		}
	}

}