package com.semaphore;

public class SemaphoreRunable implements Runnable{

	private SemaphoreTest st = new SemaphoreTest();
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		st.doSomeThing();
	}

}
