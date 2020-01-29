package com.biz.javabook;

public class threadGroupEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadGroup main = Thread.currentThread().getThreadGroup();
		ThreadGroup grp1 = new ThreadGroup("group1");
		ThreadGroup grp2 = new ThreadGroup("group2");
		
		ThreadGroup subGrp1 = new ThreadGroup(grp1, "SubGroup1"); 
		grp1.setMaxPriority(3); 
		
		Runnable r = new Runnable() {
			public void run() {
				try {
					Thread.sleep(1000);
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		};
		
		new Thread(grp1, r, "th1").start();
		new Thread(subGrp1,r, "th2").start();
		new Thread(grp2,r,"th3").start();
		
		System.out.println(">>List of ThreadGroup : "+main.getName()+", Active ThreadGroup: "+ main.activeGroupCount()+ ",Active Thread:"+main.activeCount());
		main.list();

	}

}
