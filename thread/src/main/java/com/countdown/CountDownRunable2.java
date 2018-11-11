package com.countdown;

import java.util.concurrent.CountDownLatch;

public class CountDownRunable2 implements Runnable{
	private CountDownTestData cdd;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		cdd.dugubaitian();	
	}
	public CountDownRunable2(CountDownTestData cdd) {
		super();
		this.cdd = cdd;
	}
}
