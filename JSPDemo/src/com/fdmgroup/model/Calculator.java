package com.fdmgroup.model;

public class Calculator {

	private int a;
	private int b;
	
	public Calculator() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Calculator(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	
	public int add(){
		return a + b;
	}
	
	public int sub(){
		return a - b;
	}
	
	public int mul(){
		return a * b;
	}
	
	public int divide(){
		if (b != 0){
			return a / b;			
		}
		else{
			return 0;
		}
	}
	
	
	@Override
	public String toString() {
		return "Calculator [a=" + a + ", b=" + b + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + a;
		result = prime * result + b;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Calculator other = (Calculator) obj;
		if (a != other.a)
			return false;
		if (b != other.b)
			return false;
		return true;
	}
	
	
}
