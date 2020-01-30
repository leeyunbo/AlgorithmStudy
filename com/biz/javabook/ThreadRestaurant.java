package com.biz.javabook;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/*
 * 요리사가 요리하여 음식을 테이블 위에 올려놓고
 * 테이블의 음식을 손님이 소비한다. 
 * 쓰레드로 구현하라. 
 */
public class ThreadRestaurant {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
			Table table = new Table();
			new Thread(new Cook(table), "COOK1").start();//요리사
			new Thread(new Customer(table, "donut"), "CUS1").start();//손님1
			new Thread(new Customer(table, "burger"),"CUS2").start();//손님2
			
			Thread.sleep(500000000);
			System.exit(0);

	}
}

class Customer implements Runnable {
	private Table table; //테이블
	private String food;  //먹는 음식 
	
	Customer(Table table, String food) { //생성자
		this.table = table;
		this.food = food; 
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) { //무한반복 
			try { Thread.sleep(100); } catch(InterruptedException e) {}
			String name = Thread.currentThread().getName();
			table.remove(food); //음식을 먹는다.
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
			int idx = (int)(Math.random() * table.dishNum()); //랜덤으로
			table.add(table.dishNames[idx]); //음식을 만든다.
			try { Thread.sleep(10); } catch(InterruptedException e) {}
		}
	}
}

class Table {
	String[] dishNames = {"donut", "donut", "burger"};
	final int MAX_FOOD = 2; // 최대 2개 
	private ArrayList<String> dishes = new ArrayList<>(); // 테이블 음식 목록
	
	private ReentrantLock lock = new ReentrantLock(); //일반적인 Lock 
	private Condition forCook = lock.newCondition(); //요리사용 condition
	private Condition forCus = lock.newCondition(); //손님용 condition
	public void add(String dish) {
		lock.lock(); //락을 건다.
			try {
				while(dishes.size() >= MAX_FOOD) { //음식을 못만드는 상황 
					String name = Thread.currentThread().getName();
					System.out.println(name + " is waiting");
					try {forCook.await();Thread.sleep(500);} catch(InterruptedException e) {} //wait!
				}
				dishes.add(dish);
				forCus.signal();
				System.out.println("Dishes :" + dishes.toString());
			} finally {
				lock.unlock(); //어떤 일이 일어나든 lock을 반환해야함.
			}
	}
	
	public void remove(String dishName) {
		lock.lock(); //락을 건다.
			try {
				while(dishes.size()==0) { //음식이 없으면 먹을 수 없다.
					String name = Thread.currentThread().getName(); 
					System.out.println(name+ " is waiting.");
					try {forCus.await(); Thread.sleep(500);} catch(InterruptedException e) {} //wait!
				}

				for(int i=0; i<dishes.size(); i++) { //특정음식을 제거 
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
