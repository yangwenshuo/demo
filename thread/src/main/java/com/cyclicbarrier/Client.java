package com.cyclicbarrier;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
	public static void main(String[] args) {


//		cyclicbarrier��countdownlatch�Ĺ������������һ�����ֵ�


		ARunable ar = new ARunable();
		
		ExecutorService threadpool = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 5; i++) {
			threadpool.submit(ar);
		}
		
		
	}
}
