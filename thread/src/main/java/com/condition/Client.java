package com.condition;

public class Client {
	public static void main(String[] args) throws InterruptedException {
		
		ConditionTest ct = new ConditionTest();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				ct.doSomeThingc11();
			}
		}).start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				ct.doSomeThingc21();
			}
		}).start();
		
		
		Thread.currentThread().sleep(1000);
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				ct.doSomeThingc12();
			}
		}).start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				ct.doSomeThingc22();
			}
		}).start();
		
		
		
		
	}
}
