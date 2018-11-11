package com.lock;

public class ClientLockInterrupt {
	public static void main(String[] args) throws InterruptedException {
		SynData sd = new SynData();
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					sd.doSomeThingInterrupt();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					sd.doSomeThingInterrupt();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		t2.start();
		
		t1.start();
		Thread.currentThread().sleep(1000);
		t1.interrupt();
		
		
		
	}
}
