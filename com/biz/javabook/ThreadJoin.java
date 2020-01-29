package com.biz.javabook;

public class ThreadJoin {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadJoin1 gc = new ThreadJoin1(); 
		gc.setDaemon(true);
		gc.start();
		
		int requiredMemory = 0;
		
		for(int i=0; i<20; i++) {
			requiredMemory = (int) (Math.random() *10) *20;
			
			if(gc.freeMemory() < requiredMemory || gc.freeMemory() < gc.totalMemory() * 0.4) {
				gc.interrupt();
			}
			
			gc.usedMemory += requiredMemory;
			System.out.println("usedMemory: " + gc.usedMemory);
		}
	}
}

class ThreadJoin1 extends Thread {
	final static int MAX_MEMORY = 1000; 
	int usedMemory = 0;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		while(true) {
			try {
				Thread.sleep(10 * 1000); 
			} catch(InterruptedException e) {
				System.out.println("Awaken by Interrupt()");
			}
			gc();
			System.out.println("Garbage Collected. Free Memory : " + freeMemory());
		}
	}
	
	public void gc() {
		usedMemory -= 300; 
		if(usedMemory <0) usedMemory = 0;
	}
	
	public int totalMemory() { return MAX_MEMORY; }
	public int freeMemory( ) { return MAX_MEMORY - usedMemory;}
	
	
}
