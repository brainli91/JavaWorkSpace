package com.fdmgroup;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Checkout {

	
		public Checkout(){
			super();
		}
	

		public double calculatePrice(Basket basket){
			
			double total = 0.0;
			for (Book book: basket.getBooks()){
				total = total + book.getPrice();
			}
			if (basket.size() >2 && basket.size() <6){
				total = total*0.99;
			}
			else if (basket.size() >=6 && basket.size() <9){
				total = total*0.98;
			}
			else if (basket.size() ==9 ){
				total = total*0.97;
			}
			else if (basket.size() >=10 && basket.size() <12){
				total = total*0.87;
			}
			else if (basket.size() >=12&& basket.size() < 21){
				total = total*0.86;
			}
			else if (basket.size() >= 21){
				total = total*0.83;
			}
			
			return total;
		}


		
}
