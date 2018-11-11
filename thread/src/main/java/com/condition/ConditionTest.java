package com.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest {
	private ReentrantLock rlock = new ReentrantLock();
	private Condition c1 = rlock.newCondition();
	private Condition c2 = rlock.newCondition();
	
	public void doSomeThingc11() {
		rlock.lock();
		try {
			c1.await();
			for (int i = 0; i < 5; i++) {
				System.out.println("我是c1的第一个线程");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			rlock.unlock();
		}
	}
	
	public void doSomeThingc12() {
		rlock.lock();
		for (int i = 0; i < 5; i++) {
			System.out.println("我是c1的第二个线程");
		}
		c1.signal();
		//rlock.unlock();
	}
	
	public void doSomeThingc21() {
		rlock.lock();
		try {
			c2.await();
			for (int i = 0; i < 5; i++) {
				System.out.println("我是c2的第一个线程");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			rlock.unlock();
		}
	}
	
	public void doSomeThingc22() {
		rlock.lock();
		for (int i = 0; i < 5; i++) {
			System.out.println("我是c2的第二个线程");
		}
		c2.signal();
		//rlock.unlock();
	}
}
