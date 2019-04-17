package com.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class ARunable implements Runnable{
	CyclicBarrier cb = new CyclicBarrier(5,new Runnable() {

		//parties表示屏障拦截的线程数量，当屏障撤销时，先执行barrierAction，然后在释放所有线程
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("大爷们都出来了 开黑去" + Thread.currentThread().getName());
		}
	});

	//上面这个cyclicbarraier这个东西上面定义的时候我们后面跟上了一个
	//回调的函数,这样的弄的话每线程集合一次就会执行一下这个,
	//其实没必要弄
	
	int i = 0;
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("本大爷进来啦" + Thread.currentThread().getName());
		i++;
		try {


			//这个cyclicbarrier多次调用await()函数
			//对函数的跑动多次进行整合才是
			//这个东西的核心所在


			cb.await();
			System.out.println("本大爷又进来啦" + Thread.currentThread().getName());
			cb.await();
			System.out.println("222222222222222本大爷又进来啦" + Thread.currentThread().getName());
			cb.await();


		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
