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
				System.out.println("我来了");
				System.out.println(Thread.currentThread().getName());
			}
		}, 5000);
		
		//可以看出定时器也是开启了一个线程,异步回调得东西.
		
		
		
	}
}
