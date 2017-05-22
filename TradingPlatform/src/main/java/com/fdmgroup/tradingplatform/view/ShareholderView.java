package com.fdmgroup.tradingplatform.view;

import java.util.Scanner;

public class ShareholderView {
	
	static Scanner scanner = new Scanner(System.in);
	
	public int ShareholderPage(){
		System.out.println("*****************SHAREHOLDER PAGE*****************");
		System.out.println("1....View My Profile\n2....Change My Profile \n3....View My Portfolio\n4....Send Request \n5....View History of Request \n6....View History of Trades\n0....Logout");

		System.out.print(">>");
		int opt = scanner.nextInt();
		
		return opt;
		
	}
	
	public int RequestPage(){
		System.out.println("***********SEND REQUEST**********");
		System.out.println("1....Buy Request\n2....Sell Request");
		
		System.out.print(">>");
		int opt = scanner.nextInt();
		return opt;
	}

}
