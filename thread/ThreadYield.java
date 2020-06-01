package thread;

public class ThreadYield {

	public static void main(String[] args) {
		YThread1 thread1 = new YThread1("*"); 
		YThread1 thread2 = new YThread1("**");
		
		thread1.start(); 
		thread2.start(); 
		
		try {
			Thread.sleep(2000); 
			thread1.suspend(); 
			Thread.sleep(2000); 
			thread2.suspend();
		} catch(Exception e) {
			e.printStackTrace();
		} 
		
	}
}

class YThread1 implements Runnable {
	
	boolean stopped = false; 
	boolean suspended = false; 
	String name; 
	Thread thread; 
	
	public YThread1(String _name) {
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
				} catch(InterruptedException e) {
					System.out.println("FAST STOP!"); // suspend 상태로 바뀌었을 때 대기 하지 않고 바로 종료
				}
			}
			else {
				Thread.yield(); // 바쁜 대기 상태를 회피하기 위한 방법
			}
		}
		
	}
	
	public void stop() {
		stopped = true; 
		thread.interrupt();
	}
	
	public void suspend() {
		suspended = true; 
		thread.interrupt();
	}
	
	public void start() {
		thread.start();
	}
	
}
