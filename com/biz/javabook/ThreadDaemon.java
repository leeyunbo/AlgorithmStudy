package com.biz.javabook;

public class ThreadDaemon implements Runnable {
	static boolean autoSave = false;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t1 = new Thread(new ThreadDaemon());
		t1.setDaemon(true);
		t1.start();
		
		for(int i=0; i<=10; i++) {
			try {
				Thread.sleep(1000);
			} catch(Exception e) {
				e.printStackTrace();
			}
			System.out.println(i);
			if(i==3) autoSave = true;
		}
		
		System.out.println("===> exit");

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			try {
				Thread.sleep(3 * 1000);
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			if(autoSave) {
				autoSave();
			}
		}
	}
	
	public void autoSave() {
		System.out.println("===>autoSave()");
	}
	
	

}
