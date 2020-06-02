package thread;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafeQueue {
	public static void main(String[] args) {
		SafeQueue queue = new SafeQueue(); 
		Thread consumer = new Thread(new Consumer(queue));
		Thread supplier = new Thread(new Supplier(queue)); 
		consumer.start();
		supplier.start();
	}
}

//Safe-Queue
class SafeQueue {
	private Queue<Integer> queue = new LinkedList<>();
	private ReentrantLock lock = new ReentrantLock(); 
	private Condition forConsumer = lock.newCondition();
	private Condition forSupplier = lock.newCondition();
	
	void add(int num) {
		try {
			lock.lock();
			queue.add(num);
			System.out.println(queue.toString());
			forConsumer.signal();
		} finally {
			lock.unlock();
		}
	}
	
	void remove() {
		lock.lock();
		try {
			while(queue.isEmpty()) {
				System.out.println("WAIT....");
				try {
					forConsumer.await();
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(!queue.isEmpty()) {
				System.out.println(queue.toString());
				queue.poll();
				forSupplier.signal();
			}
		} finally {
			lock.unlock();
		}
	}
}

//소비자
class Consumer implements Runnable {
	SafeQueue queue; 
	
	public Consumer(SafeQueue _queue) {
		queue = _queue;
	}
	
	@Override
	public void run() {
		while(true) {
			queue.remove();
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}

//공급자
class Supplier implements Runnable {
	SafeQueue queue; 
	
	public Supplier(SafeQueue _queue) {
		queue = _queue; 
	}
	
	@Override
	public void run() {
		while(true) {
			int num = (int)(Math.random() * 3 + 1) * 100; 
			queue.add(num);
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
