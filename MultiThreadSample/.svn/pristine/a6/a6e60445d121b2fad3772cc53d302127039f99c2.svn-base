package com.fdmgroup;

import java.util.Scanner;

public class Product extends Thread{
	
	
	public Product() {
		super();

	}

	public void produce(){
		System.out.println("Inside produce....");
		synchronized (this) {
			//this.wait(); same as wait();
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Resumed.....");
			
		}
	}
	
	public void consume(){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		System.out.println("Inside consume....");
		
		synchronized(this){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Press Enter...");
		scanner.nextLine();
		System.out.println("You Pressed Enter");
		notify();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
	}
	
	
	
	
	@Override
	public void run() {
		super.run();
		if(Thread.currentThread().getName().equals("consumer")){
			consume();
		}
		if(Thread.currentThread().getName().equals("producer")){
			produce();
		}
		
	}

	public static void main(String[] args) {
		Product pr = new Product();
		Thread producerThread = new Thread(pr,"producer");
		Thread consumerThread = new Thread(pr,"consumer");
		
		producerThread.start();
		consumerThread.start();
		
	}

}
