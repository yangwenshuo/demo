package com.waitandnotify;

public class Client {
	public static void main(String[] args) {
		
		//ע������������Ҫ��ͬ����,��ͬ��������ͬһ��������notify��wait
		
		
		
		//ע��Ҫ�������һ���ֲ���td����÷�����ͬ����.
		TestData td = new TestData();
		
		
		
		//ע���������߳�,�����̶߳�������ľֲ��������÷���
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					td.method1();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
		
		
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					td.method2();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
	}
}
