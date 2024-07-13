package com.xcode.javas.preparation.multithreading;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class HorseRace {

	JFrame frame;
	JProgressBar h1 = new JProgressBar(0,100);
	JProgressBar h2 = new JProgressBar(0,100);
	JProgressBar h3 = new JProgressBar(0,100);
	JProgressBar h4 = new JProgressBar(0,100);
	JProgressBar h5 = new JProgressBar(0,100);
	
	JLabel msg = new JLabel("");
	
	static boolean runRaceButtonIsPressed = false;
	static boolean resetRaceButtonIsPressed = false;
	static int winningHorse = 0;
	static boolean winner = false;
	
	public synchronized void finish(int i) {
		msg.setVisible(true);
		msg.setText("Horse No. "+winningHorse+" wins the race! Press Reset Race and Run Race to race again");
		if(i==100) {
			winner = true;
			System.out.println("Horse No. "+winningHorse+" wins the race! Press Reset Race and Run Race to race again");
		}
		frame.getContentPane().add(msg);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				try {
					HorseRace window = new HorseRace();
					window.frame.setVisible(true);
				}catch(Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	}

	public HorseRace() {
		initialize();
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100,100,600,430);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		h1.setStringPainted(true);
		h1.setForeground(Color.RED);
		h1.setBounds(150, 129, 259, 14);
		frame.getContentPane().add(h1);
		
		h2.setStringPainted(true);
		h2.setForeground(Color.GREEN);
		h2.setBounds(150, 159, 259, 14);
		frame.getContentPane().add(h2);
		
		h3.setStringPainted(true);
		h3.setForeground(Color.BLUE);
		h3.setBounds(150, 189, 259, 14);
		frame.getContentPane().add(h3);

		h4.setStringPainted(true);
		h4.setForeground(Color.ORANGE);
		h4.setBounds(150, 219, 259, 14);
		frame.getContentPane().add(h4);
		
		h5.setStringPainted(true);
		h5.setForeground(Color.BLACK);
		h5.setBounds(150, 249, 259, 14);
		frame.getContentPane().add(h5);
		
		msg.setBounds(85, 100, 410, 14);
		msg.setVisible(true);
		frame.getContentPane().add(msg);
		
		JButton btnStart = new JButton("Run Race");
		btnStart.addActionListener(new RunRace());
		btnStart.setBounds(50, 287, 155, 40);
		frame.getContentPane().add(btnStart);

		JButton btnReset = new JButton("Reset Race");
		btnReset.addActionListener(new ResetRace());
		btnReset.setBounds(205, 287, 155, 40);
		frame.getContentPane().add(btnReset);
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.addActionListener(new Quit());
		btnQuit.setBounds(360, 287, 155, 40);
		frame.getContentPane().add(btnQuit);
	}
	
	class RunRace implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			if(!runRaceButtonIsPressed) {
				msg.setVisible(false);
				resetRaceButtonIsPressed = false;
				runRaceButtonIsPressed = true;
				H1 h1 = new H1();
				h1.start();
				H2 h2 = new H2();
				h2.start();
				H3 h3 = new H3();
				h3.start();
				H4 h4 = new H4();
				h4.start();
				H5 h5 = new H5();
				h5.start();
			}
		}
	}
	
	class ResetRace implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			if(!resetRaceButtonIsPressed) {
				msg.setVisible(false);
				resetRaceButtonIsPressed = true;
				runRaceButtonIsPressed = false;
				winner = false;
				
				H1 h1 = new H1();
				h1.reset();
				H2 h2 = new H2();
				h2.reset();
				H3 h3 = new H3();
				h3.reset();
				H4 h4 = new H4();
				h4.reset();
				H5 h5 = new H5();
				h5.reset();
			}
		}
	}
	
	class Quit implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			System.exit(0);
		}
	}
	
	class H1 extends Thread{
		public void reset() {
			h1.setValue(0);
			h1.repaint();
		}
		
		public void run() {
			for(int i=0;i<101;i++) {
				System.out.println("Executing H1--"+i);
				if(winner) {
					break;
				}
				h1.setValue(i);
				h1.repaint();
				if(i==100) {
					winningHorse = 1;
					finish(i);
				}
				
				try {
					long time = Math.abs(UUID.randomUUID().getMostSignificantBits()%60);
					System.out.println("H1--> "+time);
					Thread.sleep(time);
				}catch(InterruptedException err) {
					err.printStackTrace();
				}
				
			}
		}
	}
	
	class H2 extends Thread{
		public void reset() {
			h2.setValue(0);
			h2.repaint();
		}
		
		public void run() {
			for(int i=0;i<101;i++) {
				System.out.println("Executing H2--"+i);
				if(winner) {
					break;
				}
				h2.setValue(i);
				h2.repaint();
				if(i==100) {
					winningHorse = 2;
					finish(i);
				}
				
				try {
					long time = Math.abs(UUID.randomUUID().getMostSignificantBits()%60);
					System.out.println("H2--> "+time);
					Thread.sleep(time);
				}catch(InterruptedException err) {
					err.printStackTrace();
				}
				
			}
		}
	}
	
	class H3 extends Thread{
		public void reset() {
			h3.setValue(0);
			h3.repaint();
		}
		
		public void run() {
			for(int i=0;i<101;i++) {
				System.out.println("Executing H3--"+i);
				if(winner) {
					break;
				}
				h3.setValue(i);
				h3.repaint();
				if(i==100) {
					winningHorse = 3;
					finish(i);
				}
				
				try {
					long time = Math.abs(UUID.randomUUID().getMostSignificantBits()%60);
					System.out.println("H3--> "+time);
					Thread.sleep(time);
				}catch(InterruptedException err) {
					err.printStackTrace();
				}
				
			}
		}
	}
	
	class H4 extends Thread{
		public void reset() {
			h4.setValue(0);
			h4.repaint();
		}
		
		public void run() {
			for(int i=0;i<101;i++) {
				System.out.println("Executing H4--"+i);
				if(winner) {
					break;
				}
				h4.setValue(i);
				h4.repaint();
				if(i==100) {
					winningHorse = 4;
					finish(i);
				}
				
				try {
					long time = Math.abs(UUID.randomUUID().getMostSignificantBits()%60);
					System.out.println("H4--> "+time);
					Thread.sleep(time);
				}catch(InterruptedException err) {
					err.printStackTrace();
				}
				
			}
		}
	}
	
	class H5 extends Thread{
		public void reset() {
			h5.setValue(0);
			h5.repaint();
		}
		
		public void run() {
			for(int i=0;i<101;i++) {
				System.out.println("Executing H5--"+i);
				if(winner) {
					break;
				}
				h5.setValue(i);
				h5.repaint();
				if(i==100) {
					winningHorse = 5;
					finish(i);
				}
				
				try {
					long time = Math.abs(UUID.randomUUID().getMostSignificantBits()%60);
					System.out.println("H5--> "+time);
					Thread.sleep(time);
				}catch(InterruptedException err) {
					err.printStackTrace();
				}
				
			}
		}
	}
	
	
	
}
