package com.fdmgroup.exercises;

import java.util.Scanner;

public class ExerciseSet {

	
	public static void main(String args[])
	   {
		matrixMutiply();
		
		
		//Problem 2:given an array of integers, sort the array.
		int i;
		int temp;
		boolean sorted = true;
		
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the number of elements that you want to input: ");
		i = in.nextInt();
		int list[] = new int [i];
		int vlist[] = new int [i];
		
		System.out.println("Enter an unsorted array of integers");
		for (int a = 0; a<i; a++){
			list[a] = in.nextInt();
		}
		while(sorted)
		{
			sorted=false;
			for (int j=0; j<list.length-1;j++){
				if (list[j] < list[j+1]){
					temp = list[j];
					list[j] = list [j+1];
					list[j+1] = temp;
					sorted=true;
					
				}
			}
			
		}
		
		for (int l=0; l<list.length;l++){
			
			vlist[l] = list[i-l-1];
		}
		System.out.print("Descending Sorted array: ");
		for (int k=0; k<list.length; k++){
			System.out.print(list[k] + " ");
			
		}
		System.out.println("");
		
 		System.out.print("Ascending Sorted array: ");
 		for (int k=0; k<list.length; k++){
 			System.out.print(vlist[k] + " ");
 			
 		}
 		System.out.println("");
 		
 		
 		//Problem 3: given an array , calculate the most frequent number in that array
 		
 		i=0;
		
		System.out.println("Enter the number of elements that you want to input: ");
		int num = in.nextInt();
		int list2[] = new int [i];
		
		System.out.println("Enter an unsorted array of integers");
		for (int a = 0; a<i; a++){
			list2[a] = in.nextInt();
		}
		getPopularElement(list2);
		
	   }
	
	
	//Problem 1: Create a function which multiplies 2 matrices together
	public static void matrixMutiply(){
		int m, n, p, q, c, d, k , sum = 0;
		 
	      Scanner in = new Scanner(System.in);
	      System.out.println("Enter the number of rows and columns of first matrix");
	      m = in.nextInt();
	      n = in.nextInt();
	 
	      int first[][] = new int[m][n];
	 
	      System.out.println("Enter the elements of first matrix");
	 
	      for ( c = 0 ; c < m ; c++ )
	         for ( d = 0 ; d < n ; d++ )
	            first[c][d] = in.nextInt();
	 
	      System.out.println("Enter the number of rows and columns of second matrix");
	      p = in.nextInt();
	      q = in.nextInt();
	 
	      if ( n != p )
	         System.out.println("Matrices with entered orders can't be multiplied with each other.");
	      else
	      {
	         int second[][] = new int[p][q];
	         int multiply[][] = new int[m][q];
	 
	         System.out.println("Enter the elements of second matrix");
	 
	         for ( c = 0 ; c < p ; c++ )
	            for ( d = 0 ; d < q ; d++ )
	               second[c][d] = in.nextInt();
	 
	         for ( c = 0 ; c < m ; c++ )
	         {
	            for ( d = 0 ; d < q ; d++ )
	            {   
	               for ( k = 0 ; k < p ; k++ )
	               {
	                  sum = sum + first[c][k]*second[k][d];
	               }
	 
	               multiply[c][d] = sum;
	               sum = 0;
	            }
	         }
	 
	         System.out.println("Product of entered matrices:-");
	 
	         for ( c = 0 ; c < m ; c++ )
	         {
	            for ( d = 0 ; d < q ; d++ )
	               System.out.print(multiply[c][d]+"\t");
	 
	            System.out.print("\n");
	         }
	      }
	   }  
	
	public static int getPopularElement(int[] a)
	{
	  int count = 1, tempCount;
	  int popular = a[0];
	  int temp = 0;
	  for (int i = 0; i < (a.length - 1); i++)
	  {
	    temp = a[i];
	    tempCount = 0;
	    for (int j = 1; j < a.length; j++)
	    {
	      if (temp == a[j])
	        tempCount++;
	    }
	    if (tempCount > count)
	    {
	      popular = temp;
	      count = tempCount;
	    }
	  }
	  return popular;
	}
	
	
}
	