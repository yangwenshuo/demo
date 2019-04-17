package com.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class SynData {
	
	//lock要放在局部变量里
	private ReentrantLock lock = new ReentrantLock();

	//如果是lokc.lock()的话,你在外面调用thread.interrupted(),如果你
	//没有获取到锁的话是不会响应你的interrrupted()函数的
	//如果是lock.lockinterrupt()的话不管你获没获取锁都会响应你的interrupt()


	//还有就是interrupt()这方法如果线程里没有sleep() join await()这种会阻塞的函数,线程就是正常的跑,
	// 你在外面在怎么调用interrupt()函数也是没用的,也不会有异常产生,他这东西只是发了个信号
	public void doSomeThingInterrupt() {
		try {
			lock.lockInterruptibly();
		
			for (; ;) {
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			lock.unlock();
		}
	}

	public void doSomeThing() {
		lock.lock();
		try {
			for (int i = 0; i < 100; i++) {
				System.out.println(Thread.currentThread().getName() + "啦啦啦" + i);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			lock.unlock();
		}
	}
	
	public void doSomeThingTryLock() {
		boolean flag = lock.tryLock();
		
		if(flag == true) {
			try {
				for (int i = 0; i < 100; i++) {
					System.out.println(Thread.currentThread().getName() + "啦啦啦" + i);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}finally {
				lock.unlock();
			}
		}else {
			System.out.println("大哥 我打不过他啊");
		}
		
	}
	
	
	
	public void doSomeThingTryLockTime() {
		
		//这种可能获取不到锁的地方在finally释放的时候要先用isHeldByCurrentTread方法判断下
		//是不是当前线程占有
		try {
			if(lock.tryLock(5, TimeUnit.SECONDS)) {
				System.out.println("我获得锁了");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(lock.isHeldByCurrentThread()) {
				lock.unlock();
			}
		}
	}
}
