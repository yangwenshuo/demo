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
	
	int i = 0;
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("本大爷进来啦" + Thread.currentThread().getName());
		i++;
		try {
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
