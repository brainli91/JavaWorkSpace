package com.fdmgroup.fileiotddwalthrough.controller;

import java.util.List;

import com.fdmgroup.fileiotddwalthrough.entities.User;
import com.fdmgroup.fileiotddwalthrough.entities.UserFactory;
import com.fdmgroup.fileiotddwalthrough.io.ReadCommand;
import com.fdmgroup.fileiotddwalthrough.io.WriteCommand;

public class RegistrationController {
	
	private UserFactory userFactory;
	private WriteCommand writeCommand;
	private ReadCommand readCommand;

	public RegistrationController(UserFactory userFactory, WriteCommand writeCommand, ReadCommand readCommand){
		this.userFactory = userFactory;
		this.writeCommand = writeCommand;
		this.readCommand = readCommand;
	}
	
	public void registerUser(String username, String password, String role){
		User user = userFactory.createUser(username, password, role);
		writeCommand.write(user);
	}
	
	public List<User> getAllUser(){
		return readCommand.read();
	}
}
