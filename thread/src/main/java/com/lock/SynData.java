package com.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SynData {
	
	//lockҪ���ھֲ�������
	private ReentrantLock lock = new ReentrantLock();
	
	
	public void doSomeThingInterrupt() {
		try {
			lock.lockInterruptibly();
		
			for (; ;) {
		
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
				System.out.println(Thread.currentThread().getName() + "������" + i);
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
					System.out.println(Thread.currentThread().getName() + "������" + i);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}finally {
				lock.unlock();
			}
		}else {
			System.out.println("��� �Ҵ򲻹�����");
		}
		
	}
	
	
	
	public void doSomeThingTryLockTime() {
		
		//���ֿ��ܻ�ȡ�������ĵط���finally�ͷŵ�ʱ��Ҫ����isHeldByCurrentTread�����ж���
		//�ǲ��ǵ�ǰ�߳�ռ��
		try {
			if(lock.tryLock(5, TimeUnit.SECONDS)) {
				System.out.println("�һ������");
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
