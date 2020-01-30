package com.biz.javabook;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/*
 * �丮�簡 �丮�Ͽ� ������ ���̺� ���� �÷�����
 * ���̺��� ������ �մ��� �Һ��Ѵ�. 
 * ������� �����϶�. 
 */
public class ThreadRestaurant {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
			Table table = new Table();
			new Thread(new Cook(table), "COOK1").start();//�丮��
			new Thread(new Customer(table, "donut"), "CUS1").start();//�մ�1
			new Thread(new Customer(table, "burger"),"CUS2").start();//�մ�2
			
			Thread.sleep(500000000);
			System.exit(0);

	}
}

class Customer implements Runnable {
	private Table table; //���̺�
	private String food;  //�Դ� ���� 
	
	Customer(Table table, String food) { //������
		this.table = table;
		this.food = food; 
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) { //���ѹݺ� 
			try { Thread.sleep(100); } catch(InterruptedException e) {}
			String name = Thread.currentThread().getName();
			table.remove(food); //������ �Դ´�.
			System.out.println(name + " ate a " + food);
		}
	}
	
	
}

class Cook implements Runnable {
	private Table table; 
	Cook(Table table) { this.table = table; } 
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			int idx = (int)(Math.random() * table.dishNum()); //��������
			table.add(table.dishNames[idx]); //������ �����.
			try { Thread.sleep(10); } catch(InterruptedException e) {}
		}
	}
}

class Table {
	String[] dishNames = {"donut", "donut", "burger"};
	final int MAX_FOOD = 2; // �ִ� 2�� 
	private ArrayList<String> dishes = new ArrayList<>(); // ���̺� ���� ���
	
	private ReentrantLock lock = new ReentrantLock(); //�Ϲ����� Lock 
	private Condition forCook = lock.newCondition(); //�丮��� condition
	private Condition forCus = lock.newCondition(); //�մԿ� condition
	public void add(String dish) {
		lock.lock(); //���� �Ǵ�.
			try {
				while(dishes.size() >= MAX_FOOD) { //������ ������� ��Ȳ 
					String name = Thread.currentThread().getName();
					System.out.println(name + " is waiting");
					try {forCook.await();Thread.sleep(500);} catch(InterruptedException e) {} //wait!
				}
				dishes.add(dish);
				forCus.signal();
				System.out.println("Dishes :" + dishes.toString());
			} finally {
				lock.unlock(); //� ���� �Ͼ�� lock�� ��ȯ�ؾ���.
			}
	}
	
	public void remove(String dishName) {
		lock.lock(); //���� �Ǵ�.
			try {
				while(dishes.size()==0) { //������ ������ ���� �� ����.
					String name = Thread.currentThread().getName(); 
					System.out.println(name+ " is waiting.");
					try {forCus.await(); Thread.sleep(500);} catch(InterruptedException e) {} //wait!
				}

				for(int i=0; i<dishes.size(); i++) { //Ư�������� ���� 
					if(dishName.contentEquals(dishes.get(i))) {
						dishes.remove(i);
						forCook.signal();
						return;
					}
				}
			
			} finally {
				lock.unlock();
			}
	}
	
	public int dishNum() { return dishNames.length; }
}
