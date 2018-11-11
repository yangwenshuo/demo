package com.waitandnotify;

public class TestData {
	
	
	//我们通过这个标志位来控制哪一个线程继续向下自画像.
	public int i = 0;
	
	
	
	
	//注意这两个函数要是同步得,且同步对象是同一个才能玩notify和wait
	public synchronized void method1() throws InterruptedException {
		
		if(i==1) {
			
			
			//因为这是一个同步方法，锁对象是this，所以是this.wait();
			this.wait();
		}else {
			for(int i = 0;i<20;i++) {
				System.out.println("A打印啦啦啦啦");
			}
			i=1;
			this.notify();
			
			//通知后马上就把自己给wait了,等待别人得通知.
			this.wait();
			
			for(int i = 0;i<20;i++) {
				System.out.println("C打印啦啦啦啦");
			}
		}
		
	}
	
	
	
	public synchronized void method2() throws InterruptedException {
		if(i==0) {
			this.wait();
		}else {
			for(int i = 0;i<10;i++) {
				System.out.println("B打印啦啦啦啦");
			}
			i=0;
			this.notify();
		}
	}
	
	
	
}
