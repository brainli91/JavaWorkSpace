package com.fdmgroup;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class StreamApp {

	public static void main(String[] args) {
		//echo();
		//echo2();
		//displayContentOfFile();
		//displayContentOfFileUsingCharStream();
		//copyFiles();
		//copyBinaryFiles();
		//createDir();
		storeData();
		//loadData();
		
	}
	
	private static void loadData() {

		DataInputStream dis = null;
		
		try {
			dis = new DataInputStream(new FileInputStream("./myfiles/test.dat"));
			int age = dis.readInt();
			String name = dis.readUTF();
			boolean male = dis.readBoolean();
			double grade = dis.readDouble();
			
			System.out.println(name + " -->" + age + " -->" + grade + " is male: " + male);
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void storeData() {

		DataOutputStream dos = null;
		try {
			dos = new DataOutputStream(new FileOutputStream("./myfiles/test.dat"));
			int age = 25;
			String name = "SammyBattikha";
			boolean male = true;
			double grade = 89.95;
			
			int age2 = 18;
			String name2 = "Benjamin Fonooni";
			boolean male2 = true;
			double grade2 = 100.0;
			
			dos.writeInt(age);
			dos.writeUTF(name);
			dos.writeBoolean(male);
			dos.writeDouble(grade);

			dos.writeInt(age2);
			dos.writeUTF(name2);
			dos.writeBoolean(male2);
			dos.writeDouble(grade2);
			
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			closeStream(dos);
		}
		
	}

	private static void createDir() {
		
		File file = new File("C:/Users/Brian.li/Desktop/test.txt");
		file.mkdirs();
		System.out.println("Directories created.");
		
	}

	private static void copyBinaryFiles() {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			fis = new FileInputStream("C:/Users/Brian.li/Desktop/test.zip");
			fos = new FileOutputStream("C:/Users/Brian.li/Desktop/test_copy.zip");
			byte content[] = new byte[fis.available()];
			fis.read(content);
			fos.write(content);
			
			int r = -5;
			while (r != -1){
				r = fis.read();
				if (r != -1){
					fos.write(r);
				}
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			closeStream(fis);
			closeStream(fos);
		}
		
	}

	private static void copyFiles() {

		BufferedReader br = null;
		FileReader reader = null;
		FileWriter writer = null;
		
		try {
			br = new BufferedReader(reader= new FileReader("C:/Users/Brian.li/Desktop/file1.txt"));
			writer = new FileWriter(new File("C:/Users/Brian.li/Desktop/file2.txt"));
			String line = "";
			while ((line = br.readLine()) != null){
				writer.write(line + "\n");
				writer.write(line + "\n");
			}
			System.out.println("File copied successfully.");
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			closeStream(reader);
			closeStream(br);
			closeStream(writer);
			
		}
	}

	private static void displayContentOfFileUsingCharStream() {
		BufferedReader br = null;
		FileReader reader = null;
		
		try {
			br = new BufferedReader(reader= new FileReader("C:/Users/Brian.li/Desktop/file1.txt"));
			String line = "";
			while ((line = br.readLine()) != null){
				System.out.println(line);
			}
			br.readLine();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			closeStream(reader);
			closeStream(br);
		}
		
		
	}

	private static void displayContentOfFile() {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("C:/Users/Brian.li/Desktop/file1.txt");
			/*byte[] contents = new byte[fis.available()];
			fis.read(contents);*/
			int r = -5;
			String content = "";
			while (r != -1){
				r = fis.read();
				if (r != -1){
					content += (char) r;
					
				}
			}
			
			System.out.println(new String(content));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			closeStream(fis);
		}
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

	private static void echo(){
		String inputText = "";
		int r = -5;
		
		try {
				while (r != 10){
				r = System.in.read();
				inputText += (char) r;
			}
		}
		catch (IOException e) {
		// TODO Auto-generated catch block
				e.printStackTrace();
		}
		System.out.println("You typed:" + inputText);
		
	}
	
	private static void echo2(){
		Scanner scanner = new Scanner(System.in);
		String inputText = "";
		while (!inputText.equalsIgnoreCase("exit")){
			
			inputText = scanner.nextLine();
			System.out.println("You typed: " + inputText);
		}
		
	}
	
}
