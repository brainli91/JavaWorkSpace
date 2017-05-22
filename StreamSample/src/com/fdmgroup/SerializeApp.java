package com.fdmgroup;

import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeApp {

	public static void main(String[] args) {
		User user = new User(1, "alex", "123456", new Role("Admin"));
		user.number = 78;
		storeUser(user);
		User user2 = LoadUser();
		System.out.println(user2);
		
		System.out.println(user.hashCode() + "     -----     " + user2.hashCode());
	}

	private static User LoadUser() {
		User user = null;
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream("./myfiles/user.ser"));
			user = (User) ois.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeStream(ois);
		}
		return user;
	}

	private static void storeUser(User user) {
		
		ObjectOutputStream cos = null;
		
		try {
			cos = new ObjectOutputStream(new FileOutputStream("./myfiles/user.ser"));
			cos.writeObject(user);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			closeStream(cos);
			
		}
		
		System.out.println("User object stored");
	}
	
	private static void closeStream(Closeable  closeable) {
		if (closeable != null){
			try {
				closeable.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
