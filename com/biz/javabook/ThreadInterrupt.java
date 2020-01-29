package com.biz.javabook;

import javax.swing.JOptionPane;

public class ThreadInterrupt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runnable r = new ThreadInterrupts();
		Thread t1 = new Thread(r);
		t1.start();
		String input = JOptionPane.showInputDialog("�ƹ� ���̳� �Է��ϼ���.");
		System.out.println("�Է��Ͻ� ���� " + input + " �Դϴ�.");
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
			catch(InterruptedException e) { //Sleep() �Լ��� �������� ��, Interrupt�� �ָ� InterruptException�� �߻��Ѵ�. �׷��� �ڵ����� Interrupt ���¸� false�� ��ȯ��Ű�� ������ ������� �ʴ´�. ����
																// catch�� �ȿ� Interrupt()�� ������Ѿ� �Ѵ�.
				Thread.currentThread().interrupt();
			}
	
		}
		System.out.println("����");
	}
}