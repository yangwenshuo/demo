package com.lock;

public class ClientSimpleLock {
	public static void main(String[] args) {
		
		//������û,���Ǵ����߳���new Thread(new Runable(xxx))
		
		//������ǿ��Կ����ڶ����߳�������
		
		SynData sd = new SynData();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				sd.doSomeThing();
			}
		}).start();
		
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				sd.doSomeThing();
			}
		}).start();
	}
}
