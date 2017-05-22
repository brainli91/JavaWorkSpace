package com.fdmgroup;

import java.util.LinkedList;
import java.util.Random;


public class ProducerConsumer implements Runnable{
	
	private LinkedList<Integer> numbers = new LinkedList<Integer>();
	private final int CAPCITY = 10;
	private Random random = new Random();
	private Object lock = new Object();
	private boolean active = true;
	
	

	
	public ProducerConsumer() {
		super();

	}

	public void produce(){
		while(active){
			synchronized (lock) {
				try {
					if (numbers.size() ==CAPCITY)
					lock.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				numbers.add(random.nextInt(100));
				lock.notify();
				}
		}
		
	}
	
	
	public void consume(){
		while(active){
			synchronized (lock) {
				
				try {
					if(numbers.isEmpty())
					lock.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("ListedLink Size "+ numbers.size()+"--------->"+ numbers.removeFirst());
				lock.notify();
				}
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	
	
	
	@Override
	public void run() {

		if(Thread.currentThread().getName().equals("consumer")){
			consume();
		}
		else if(Thread.currentThread().getName().equals("producer")){
			produce();
		}
		
	}

	public static void main(String[] args) {
		ProducerConsumer pr = new ProducerConsumer();
		Thread producerThread = new Thread(pr,"producer");
		Thread consumerThread = new Thread(pr,"consumer");
		
		producerThread.start();
		consumerThread.start();
		
	}
}
