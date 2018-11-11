package com.exchanger;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Exchanger {
	
	public static void main(String[] args) {
		ExchangerData cd = new ExchangerData();
		
		ExecutorService threadPool = Executors.newCachedThreadPool();
		
		threadPool.submit(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				cd.sendBoll();
			}
		});
		
		new Thread().suspend();
		
		threadPool.submit(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				cd.sendJMS();
			}
		});
		
	}
}
