package com.fdmgroup;

public class MaximumTest {
	public static void main(String[] args) {
		System.out.printf("Maximim of %d, %d, and %d is %d\n\n",3,4,5,
				maximum(3,4,5));
		System.out.printf("Maximim of %.if, %.if, and%.if is %.if\n\n",3,4,5,
				maximum(6.6,7.7,8.8));
		System.out.printf("Maximim of %d, %d, and %d is %d\n\n",3,4,5,
				maximum(3,4,5));
		
	}


	
	public static <T extends Comparable<T> >T maximum(T x, T y, T z)
	{
		T max =x;
		
		if (y.compareTo( max )> 0)
			max = y;
		
		if (z.compareTo(max )>0)
			max =z;
		
		return max;
		
	}
}
