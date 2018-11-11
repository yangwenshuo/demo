package com.betweenThreadShare;

public class ARunable implements Runnable{

	private int num = 10;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		for (int i = 0; i < num; i++) {
			
			System.out.println(Thread.currentThread().getName() + "À²À²À²" + i);
		}
	}

}
