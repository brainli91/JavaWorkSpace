package com.fdmgroup;

public class Calculator {

	public int div(int a, int b) throws MyException{
		if (b == 0){
			throw new MyException();
		}
		else{
			//return 0;
			return a/b;
		}
		
	}
}
