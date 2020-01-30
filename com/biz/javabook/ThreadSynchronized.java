package com.biz.javabook;
/*
 * Synchronized를 활용한 계좌 출금 시뮬레이션 구현 
 * 출금 메소드를 임계영역으로 설정 
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
				try { Thread.sleep(1000); } catch(InterruptedException e) {}  // 다른 쓰레드가 끼어드는 상황을 보여주기 위해 일부러 쓰레드 휴식 
				balance -= money;
			} else {
				System.out.println("잔고가 부족합니다.");
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
			acc.withdraw(money); //출금 
			System.out.println("balance : " + acc.getBalance());
		}
	}
	
}
