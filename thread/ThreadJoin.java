package thread;

public class ThreadJoin {

	public static void main(String[] args) throws InterruptedException {
		IThread ithread = new IThread("BACKGROUND THREAD");
		
		ithread.start();
		
		while(true) {
			System.out.println("UI THREAD MOVE.."); 
			Thread.sleep(10000);
		}
		

	}

}

class IThread implements Runnable {

	boolean suspended = false; 
	boolean stopped = false; 
	Thread thread; 
	String name;
	
	public IThread(String _name) {
		thread = new Thread(this); 
		name = _name;
	}
	
	@Override
	public void run() {
		JThread jThread1 = new JThread("GET USER-DATA THREAD");
		JThread jThread2 = new JThread("GET BOARD-DATA THREAD");
		jThread1.start();
		jThread2.start();
		while(!stopped) {
			System.out.println("WORKER THREAD START");
			jThread1.join();
			jThread2.join();
			if(!suspended) {
				try {
					Thread.sleep(1000);
					jThread1.suspend();
					jThread2.suspend();
				} catch (InterruptedException e) {
					System.out.println(name + "Interuppted");
				}
			}
			else {
				System.out.println(name + "FAST STOP!");
				jThread1.stop();
				jThread2.stop();
				Thread.yield();
			}
		}
	}
	
	public void start() {
		thread.start();
	}
	
	public void stop() {
		stopped = true;
		thread.interrupt();
	}
	
	public void suspend() {
		suspended = true; 
		thread.interrupt();
	}
	
}

class JThread implements Runnable {

	boolean suspended = false; 
	boolean stopped = false; 
	Thread thread; 
	String name;
	
	public JThread(String _name) {
		thread = new Thread(this); 
		name = _name;
	}
	
	@Override
	public void run() {
		while(!stopped) {
			if(!suspended) {
				System.out.println(name); 
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.out.println(name + "Interuppted");
				}
			}
			else {
				System.out.println(name + "FAST STOP!");
				Thread.yield();
			}
		}
	}
	
	public void start() {
		thread.start();
	}
	
	public void stop() {
		stopped = true;
		thread.interrupt();
	}
	
	public void suspend() {
		suspended = true; 
		thread.interrupt();
	}
	
	public void join() {
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
