package com.lock;

public class ClienTryLock {
	public static void main(String[] args) {
		
		
		//看到没,trylock会去尝试获取一下,获取到了就返回true
		//返回不到就是false.
		
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

