package com.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class ARunable implements Runnable{
	CyclicBarrier cb = new CyclicBarrier(5,new Runnable() {

		//parties��ʾ�������ص��߳������������ϳ���ʱ����ִ��barrierAction��Ȼ�����ͷ������߳�
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("��ү�Ƕ������� ����ȥ" + Thread.currentThread().getName());
		}
	});
	
	int i = 0;
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("����ү������" + Thread.currentThread().getName());
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
