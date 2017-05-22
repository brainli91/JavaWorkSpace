package com.fdmgroup.GUI;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DrawApp extends JFrame implements Runnable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static DrawApp da = new DrawApp();
	private JLabel timelb1 = new JLabel("Time: ");
	private JTextField timeTF = new JTextField(20);
	private JButton startStopButton = new JButton("Start");
	private int x1 = 0;
	private int y1 = 0;
	private int x2 = 480;
	private int y2 = 480;
	
			
	
	private boolean active = false;
	
	public DrawApp() throws HeadlessException{
		super();
		init();
	}
	
	private void init() {
		setTitle("Multithread Sample");
		
		Container container = getContentPane();
		container.setLayout(new FlowLayout(FlowLayout.LEFT));
		container.add(timelb1);
		container.add(timeTF);
		container.add(startStopButton);
		
		startStopButton.addActionListener(new ActionListener(){
		
			//@Override
		public void actionPerformed(ActionEvent e){
			if (startStopButton.getText().equals("Start"))
			{
				startStopButton.setText("Stop");
				active = true;
				Thread t1 = new Thread (da, "Timer");
				Thread t2 = new Thread(da, "Draw1");
				Thread t3 = new Thread(da, "Draw2");
				t1.start();
				t2.start();
				t3.start();
			}
			
			else if (startStopButton.getText().equals("Stop")){
				startStopButton.setText("Start");
				active = false;
			}
		}
		});
	}
	
	public static void main(String[] args) {
		
		da.setSize(500, 500);
		da.setVisible(true);
		da.setResizable(false);
		da.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void run() {
		while (active){
			if (x1==480 && y1==480 &&x2==0 && y2==0 )
			{
				x1=0;
				y1=0;
				x2=480;
				y2=480;
			}
			if(Thread.currentThread().getName().equals("Timer")){
			Calendar cal = Calendar.getInstance();
			String time = cal.get(Calendar.HOUR_OF_DAY) + ":" + cal.get(Calendar.MINUTE) + ":" + cal.get(Calendar.SECOND);
			timeTF.setText(time);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			}
			
			else if(Thread.currentThread().getName().equals("Draw1")){
			Graphics graphics = getContentPane().getGraphics();
			graphics.setColor(Color.BLUE);
			graphics.fillOval(x1,y1,20,20);

			try {
				Thread.sleep(200);
				graphics.clearRect(x1, y1, 20, 20);
				x1+=10;
				y1+=10;
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
			else if(Thread.currentThread().getName().equals("Draw2")){
			Graphics graphics = getContentPane().getGraphics();
			graphics.setColor(Color.RED);
			graphics.fillOval(x2,y2,20,20);
			
			try {
				Thread.sleep(200);
				graphics.clearRect(x2, y2, 20, 20);
				x2-=10;
				y2-=10;
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	}
}

