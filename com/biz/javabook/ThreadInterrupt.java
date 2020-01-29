package com.biz.javabook;

import javax.swing.JOptionPane;

public class ThreadInterrupt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runnable r = new ThreadInterrupts();
		Thread t1 = new Thread(r);
		t1.start();
		String input = JOptionPane.showInputDialog("아무 값이나 입력하세요.");
		System.out.println("입력하신 값은 " + input + " 입니다.");
		t1.interrupt();
	}
}
class ThreadInterrupts implements Runnable {
	@Override
	public void run() {
		int i = 10;
		while(i>0 && !Thread.currentThread().isInterrupted()) {
			System.out.println(i--);
			try {
				Thread.sleep(1000);
			}
			catch(InterruptedException e) { //Sleep() 함수를 수행했을 떄, Interrupt를 주면 InterruptException이 발생한다. 그러면 자동으로 Interrupt 상태를 false로 변환시키기 때문에 종료되지 않는다. 따라서
																// catch문 안에 Interrupt()를 수행시켜야 한다.
				Thread.currentThread().interrupt();
			}
	
		}
		System.out.println("종료");
	}
}