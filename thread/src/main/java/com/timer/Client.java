package com.timer;

import java.util.Timer;
import java.util.TimerTask;

public class Client {
	public static void main(String[] args) {
		
		System.out.println(Thread.currentThread().getName());
		
		Timer t = new Timer();
		t.schedule(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("������");
				System.out.println(Thread.currentThread().getName());
			}
		}, 5000);
		
		//���Կ�����ʱ��Ҳ�ǿ�����һ���߳�,�첽�ص��ö���.
		
		
		
	}
}
