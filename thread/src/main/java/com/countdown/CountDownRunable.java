package com.countdown;

public class CountDownRunable implements Runnable{
	private CountDownTestData cdd;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		cdd.yangguo();	
	}
	public CountDownRunable(CountDownTestData cdd) {
		super();
		this.cdd = cdd;
	}
}
