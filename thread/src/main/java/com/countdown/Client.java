package com.countdown;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Client {

	public static void main(String[] args) throws InterruptedException {
		CountDownTestData cdate = new CountDownTestData();
		CountDownRunable cr = new CountDownRunable(cdate);
		CountDownRunable2 cr2 = new CountDownRunable2(cdate);
		//这样的话这两个不同的runable中的成员变量就是一样的了,我们在两种不同的线程
		//间共享了变量
		CountDownLatch cdl = cdate.getCdl();
		
		ExecutorService threadPool = Executors.newFixedThreadPool(5);
		
		for (int i = 0; i < 2; i++) {
			threadPool.submit(cr);
		}
		for (int i = 0; i < 2; i++) {
			threadPool.submit(cr2);
		}
		
		cdl.await();
		
		System.out.println("厉害厉害 都搞死了");
		
		
	}

}
