package com.lock;

public class ClienTryLock {
	public static void main(String[] args) {
		
		
		//����û,trylock��ȥ���Ի�ȡһ��,��ȡ���˾ͷ���true
		//���ز�������false.
		
		SynData sd = new SynData();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				sd.doSomeThingTryLock();
			}
		}).start();
		
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				sd.doSomeThingTryLock();
			}
		}).start();
	}
}

