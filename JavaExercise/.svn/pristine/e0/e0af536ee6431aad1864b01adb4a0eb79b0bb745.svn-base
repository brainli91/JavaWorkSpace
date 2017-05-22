package com.fdmgroup;

public class Process {
	public static int[][] multiply(int[][] a, int[][] b){
		int rowA = a.length;
		int colA = a[0].length;
		int colB = b[0].length;
		int[][] c = new int[rowA][colB];
		for (int m =0; m<rowA; m++){
			for (int n=0; n<colB; n++){
				for (int k=0; k<colA; k++){
					c[m][n] = c[m][n] + a[m][k] +b[k][n];
				}
			}
		}
		return c;
	}
	
/*	public int[] AsceArray(int array[])  {
		int temp;
		
		for (int i=0; i<array.length;i++){
			for (int j =0; j<array.length; j++){
				if (lowNum > array[j]){
					lowNum = array[j];
				}
			newArray[j] = lowNum;
			}
			
		}
		return newArray;
		
	}
*/
}
