
package com.fdmgroup;

import java.util.Scanner;

//Program that promote user for two matrix and generate a product of matrix
public class MatrixProduct {

	public static void main(String[] args) {
		
		
		Scanner s = new Scanner(System.in);
		System.out.print("Enter number of rows in A: ");
		int rowA = s.nextInt();
		System.out.print("Enter number of columns in A/ rows in B: ");
		int colA = s.nextInt();
		System.out.print("Enter number of columns in B: ");
		int colB = s.nextInt();
		
		int[][] a = new int [rowA][colA];
		int[][] b = new int [colA][colB];
		System.out.println("Enter matrix A");
		for (int m = 0; m < a.length; m++){
			for (int n =0; n < a[0].length; n++){
				a[m][n] = s.nextInt();
			}
			
		}
		System.out.println("Enter matrix B");
		for (int m = 0; m < b.length; m++){
			for (int n =0; n<b[0].length; n++){
				b[m][n] = s.nextInt();
			}
			
		}
		
		int[][] c = Process.multiply(a,b);
		System.out.println("Product of A and B is");
		for (int m = 0; m < c.length; m++){
			for(int n =0; n< c[0].length;n++)
			{
				System.out.println(c[m][n] + " ");
				
			}
			System.out.println();
			
		}
			
	
	
	}


}
