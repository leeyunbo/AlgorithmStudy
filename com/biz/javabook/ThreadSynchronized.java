package com.biz.javabook;
/*
 * Synchronized�� Ȱ���� ���� ��� �ùķ��̼� ���� 
 * ��� �޼ҵ带 �Ӱ迵������ ���� 
 */
public class ThreadSynchronized {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runnable r = new ThreadSync1();
		new Thread(r).start();
		new Thread(r).start();

	}

}
class Account {
	private int balance = 1000; 
	public int getBalance() {
		return balance; 
	}
	public  void withdraw(int money) {
		synchronized(this) {
			if(balance >= money) {
				try { Thread.sleep(1000); } catch(InterruptedException e) {}  // �ٸ� �����尡 ������ ��Ȳ�� �����ֱ� ���� �Ϻη� ������ �޽� 
				balance -= money;
			} else {
				System.out.println("�ܰ� �����մϴ�.");
			}
		}
	}
}

class ThreadSync1 implements Runnable {
	Account acc = new Account();
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(acc.getBalance() > 0) {
			int money = (int)(Math.random() * 3 + 1) * 100; 
			acc.withdraw(money); //��� 
			System.out.println("balance : " + acc.getBalance());
		}
	}
	
}
