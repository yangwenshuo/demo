package com.countdown;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {

	//countdownlatch的作用是,一个线程等N个线程(这个N就是countdownlatch对象设置参数
	// 的时候指定的)
	//countdownlatch是必须配合cdl.await()方法使用的
	//这个方法的意思就是看看上面设置的N被其他线程砍光没有



	//如果没有砍光就会在这里阻塞,等待砍光,!!!!!!!!!!!!!!!!


	//等待砍光阻塞在这里,砍光后再继续跑 这才是countdownlathc的意义
    //而那个类似于信号量的东西是semaphore

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
		for (int i = 0; i < 3; i++) {
			threadPool.submit(cr2);
		}


		cdl.await();
		
		System.out.println("厉害厉害 都搞死了");
		
		
	}

}
