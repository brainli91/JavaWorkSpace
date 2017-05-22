package com.fdmgroup;

public class MyThread extends Thread{
	
	private int min;
	private int max;
	private int sleepTime;
	

	public MyThread(String name) {
		super(name);
	}
	
	public MyThread(int min, int max) {
		super();
		this.min = min;
		this.max = max;
		this.sleepTime = sleepTime;
	}
	
	public MyThread(int min, int max, int sleepTime) {
		super();
		this.min = 1;
		this.max = 10;
		this.sleepTime = 1000;
	}

	
	@Override
	public void run(){
		if(currentThread().getName().equals("T1")){
		for (int i=100; i<1000; i++){
			System.out.println("i ---------------->"+i);
			try {
				sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}
		else if(currentThread().getName().equals("T2")){
		for (int i=100; i<1000; i++){
			System.out.println("i ---------------->"+i);
			try {
				sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}
	}
	
	





	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public static void main(String[] args) {
		
		MyThread t1 = new MyThread(50,100,100);
		MyThread t2 = new MyThread(1000,2000,10);
		t1.start();
		t2.start();
		
		for (int i=0; i<11; i++){
		System.out.println("i ---------------->"+i);
		try {
			sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

		 try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		
	}

//	public static void main(String[] args) {
//		Thread.currentThread().setPriority(10);
//		Thread.currentThread().setName("Main Thread");
//		System.out.println(Thread.currentThread());
//	}
}
