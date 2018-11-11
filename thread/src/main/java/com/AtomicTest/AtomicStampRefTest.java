package com.AtomicTest;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;



public class AtomicStampRefTest {
	
	static AtomicStampedReference<Integer> num = new AtomicStampedReference<Integer>(10, 0);
	public static void main(String[] args) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				int stamp = num.getStamp();
				Integer integer = num.getReference();
				
				boolean b = num.compareAndSet(integer, integer+10, stamp, stamp+1);
			}
		}).start();
		
		
		
		
		
		
		
		
		
	}
}
