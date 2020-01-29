package com.biz.javabook;

public class ThreadYield {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadYield01 th1 = new ThreadYield01("*");
		ThreadYield01 th2 = new ThreadYield01("**");
		ThreadYield01 th3 = new ThreadYield01("***");
		th1.start();
		th2.start();
		th3.start();
		
		try {
			Thread.sleep(2000);
			th1.suspend();
			Thread.sleep(2000);
			th2.suspend();
			Thread.sleep(3000);
			th1.resume();
			Thread.sleep(3000);
			th1.stop();
			th2.stop();
			Thread.sleep(2000);
			th3.stop();
		} catch(InterruptedException e) {}
	}
}

class ThreadYield01 implements Runnable {
	boolean suspended = false; 
	boolean stopped = false; 
	
	Thread th; 
	
	ThreadYield01(String name) {
		th = new Thread(this, name); 
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		String name = th.getName();
		while(!stopped) {
			if(!suspended) {
				System.out.println(name);
				try {
					Thread.sleep(1000);
				} catch(InterruptedException e) {
					System.out.println(name + " -Interruptted");
				}
			} else {
				Thread.yield(); //yield �޼ҵ带 ���������ν� �������� while���� ���� �ʰ� ���� ���� �ð��� ���� �����忡�� �ѱ� 
			}
		}
		System.out.println(name + " -stopped");
	}
	
	public void suspend() {
		suspended = true;
		th.interrupt(); //InterruptedException�� �߻����� Sleep���� ��� ���.
		System.out.println(th.getName() + " Interrupt! --> by suspend()");
	}
	
	public void stop() {
		stopped = true; 
		th.interrupt();
		System.out.println(th.getName() + " Interrupt()! --> by stop()");
	}
	
	public void resume() {
		suspended = false; 
	}
	
	public void start() {
		th.start();
	}
	
	
}
