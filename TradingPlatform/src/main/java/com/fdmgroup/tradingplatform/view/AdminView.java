package com.fdmgroup.tradingplatform.view;

import java.util.Scanner;

public class AdminView {
	
//	public static void main(String[] args) {
//		 AdminPage();
//	}
	
	static Scanner scanner = new Scanner(System.in);
	
	public int AdminPage() {
		
		System.out.println("***********************ADMIN PAGE***********************");
		System.out.println("1......Add User\n2......Remove User\n3......Update User\n4......View all Users\n5......View User Log\n0......Logout\n");
		System.out.print(">>");
		int opt = scanner.nextInt();
		
		
		return opt;
		
	}
}
