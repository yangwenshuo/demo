package com.lock;

public class ClientSimpleLock {
	public static void main(String[] args) {
		
		//看到了没,我们创建线程是new Thread(new Runable(xxx))
		
		//其次我们可以看到第二个线程阻塞了
		
		SynData sd = new SynData();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				sd.doSomeThing();
			}
		}).start();
		
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				sd.doSomeThing();
			}
		}).start();
	}
}
