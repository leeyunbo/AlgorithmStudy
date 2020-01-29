package com.biz.javabook;

public class ThreadPriority {

	public static void main(String[] args) {
		Runnable r = new ThreadP_1();
		Runnable r2 = new ThreadP_2();
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r2);
		t2.setPriority(7);
		
		t1.start();
		t2.start();

	}

}

class ThreadP_1 implements Runnable {
	@Override
	public void run() {
		for(int i=0; i<100; i++) {
			System.out.println(Thread.currentThread().getName() + " " +ThreadEx1.server1++);
			for(int j=0; j<10000; j++);
		} 
		
		System.out.println(Thread.currentThread().getName() + " is Finished ========================>");
	}
}
class ThreadP_2 implements Runnable {
	@Override
	public void run() {
		for(int i=0; i<100; i++) {
			System.out.println(Thread.currentThread().getName() + " " +ThreadEx1.server2++);
			for(int j=0; j<10000; j++);
		}
		
		System.out.println(Thread.currentThread().getName() + " is Finished ========================>");
		
	}
	
}
