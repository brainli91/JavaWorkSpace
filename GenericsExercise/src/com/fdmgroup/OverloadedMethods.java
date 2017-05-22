package com.fdmgroup;

public class OverloadedMethods {
	
	public static void main(String[] args) {
		Integer[] integerArray ={1,2,3,4,5,6};
		Double [] doubleArray ={1.1 ,2.2 ,3.3 ,4.4 ,5.5 ,6.6};
		Character[] characterArray ={'H','E','L','L','O'};
		
		System.out.println("Array intergerArray contains:");
		printArray(integerArray);
		
		System.out.println("Array doubleArray contains:");
		printArray(doubleArray);
		
		System.out.println("Array characterArray contains:");
		printArray(characterArray);
		}
	
/*	public static void printArray( Integer[] inputArray){
		
		for (Integer element: inputArray){
			System.out.printf("%s", element);
		}
		
		System.out.println();
	}
	
	public static void printArray(Double[] inputArray){
		
		for (Double element:inputArray){
			System.out.printf("%s", element);
			
		}
	
		System.out.println();
	}
	
	public static void printArray(Character[] inputArray){
		
		for (Character element: inputArray){
			System.out.printf("%s", element);
		}
		System.out.println();
		
	}*/
	
/*	public static void printArray(T[] inputArray)
	{
	
		for (T element: inputArray){
			System.out.printf("%s", element);
		}
		
	}*/
	
	public static void printArray(Object[] inputArray){
		
		for (Object element: inputArray){
			System.out.printf("%s", element);
		}
		System.out.println();
		
	}

}
