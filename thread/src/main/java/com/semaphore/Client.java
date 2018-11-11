package com.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
	public static void main(String[] args) {
		
		ExecutorService threadPool = Executors.newFixedThreadPool(5);
		SemaphoreRunable sr = new SemaphoreRunable();
		
		for (int i = 0; i < 20; i++) {
			threadPool.submit(sr);
		}
	}
}
