package com.waitandnotify;

public class Client {
	public static void main(String[] args) {
		
		//注意这两个函数要是同步得,且同步对象是同一个才能玩notify和wait
		
		
		
		//注意要在外面搞一个局部得td里面得方法是同步得.
		TestData td = new TestData();
		
		
		
		//注意这样开线程,两个线程都用外面的局部变量调用方法
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
