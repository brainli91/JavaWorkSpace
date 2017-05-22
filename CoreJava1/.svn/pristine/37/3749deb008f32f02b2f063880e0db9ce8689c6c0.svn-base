package com.fdmgroup;

public class Arthemetic {
	private int num1;
    private int num2;
		
    public int add(){
    		return num1 + num2;
    }
    
    public int sub(){
    		return num1 - num2;
    }
    
    public int nul(){
    	return num1 * num2;
    }
    
    public int div(){
    	return num1 / num2;
    }

	public int getNum1() {
		return num1;
	}

	public void setNum1(int num1) {
		this.num1 = num1;
	}

	public int getNum2() {
		return num2;
	}

	public void setNum2(int num2) {
		this.num2 = num2;
	}
    
	public void showEvenNumbers(int min, int max){
		for (int i = min; i <= max ; i++){
			if (i % 2 == 0)
				System.out.println(i);
			
		}
	}
	
	private boolean isPrime(int num){
		int sqrt = (int) Math.sqrt(num);
		for (int i =  2; i <= sqrt; i++){
			if (num % i ==0)
				 return false;
			
		}
		return true;
	}
	
	public void showPrimeNumbers(int max){
		int i =2;
		
		 do{
			 if (isPrime(i))
				 System.out.println(i);
		 }while (i <= max );
		 i++;
		
	}
/*	public void showPrimeNumbers(int max){
		for  (int i =2; i <= max; i++){
			if (isPrime(i))
				System.out.println(i);
		}
	}
*/	
	public void switchExample(int choice){
		switch(choice){
		case 1:
			System.out.println("1111111111");
			break;
		case 2:
			System.out.println("2222222222");
			break;
		case 3:
			System.out.println("3333333333");
			break;
		case 4:
			System.out.println("44444444444");
			break;
		default:
			System.out.println("------------");
			
		}
	}
	
	public double calculateAverage(double array[]){
		double sum =0.0;
		for(double d :array){
			sum += d;
			
		}
		return sum /array.length;
		
		}
	
		
}
