package com.biz.javabook;

public class ThreadEx1 {
	static int server1 = 0;
	static int server2 = 0;
	public static void main(String[] args) {
		Runnable r1 = new ThreadEx1_2();
		Runnable r2 = new ThreadEx1_3();
		Thread t1 = new Thread(r1,"thread1");
		Thread t2 = new Thread(r2,"thread2"); //Thread »ı¼ºÀÚ(Runnable target)
		
		t1.start();
		t2.start();
	}

}

class ThreadEx1_2 implements Runnable {
	@Override
	public void run() {
		for(int i=0; i<100; i++) 
			System.out.println(Thread.currentThread().getName() + " " +ThreadEx1.server1++);
		
		System.out.println(Thread.currentThread().getName() + " is Finished ========================>");
	}
}
class ThreadEx1_3 implements Runnable {
	@Override
	public void run() {
		for(int i=0; i<100; i++) 
			System.out.println(Thread.currentThread().getName() + " " +ThreadEx1.server2++);
		
		System.out.println(Thread.currentThread().getName() + " is Finished ========================>");
		
	}
	
}
