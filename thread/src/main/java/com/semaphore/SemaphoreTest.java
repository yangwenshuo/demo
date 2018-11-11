package com.semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {
	private Semaphore sp = new Semaphore(5);
	public void doSomeThing() {
		try {
			sp.acquire(2);
			System.out.println("¿≤¿≤¿≤Œ“¿¥¿≤");
			Thread.currentThread().sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			sp.release(2);
		}
		
	}
}
