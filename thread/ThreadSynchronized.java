package thread;

public class ThreadSynchronized {
	public static void main(String[] args) {
		Runnable r = new ATMThread(); 
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);
		t1.start();
		t2.start();
	}
}

class ATMThread implements Runnable {
	Account atm = new Account();
	
	@Override
	public void run() {
		while(atm.getBalance() > 0) {
			int money = (int)(Math.random() * 3 + 1) * 100; 
			atm.withdraw(money);
			System.out.println("Balance : " + atm.getBalance());
		}
	}
}

class Account {
	private int balance = 1000;
	
	public int getBalance() {
		return balance;
	}
	
	//출금 
	public void withdraw(int money){
		synchronized(this) {
			if(balance >= money) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				balance -= money;
			}
		}
	}
	
	//입금
	public void deposit(int money) {
		balance += money;
	}
}


