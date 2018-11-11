package com.countdown;

import java.util.concurrent.CountDownLatch;

public class CountDownTestData {
	private CountDownLatch cdl = new CountDownLatch(5);
	public CountDownLatch getCdl() {
		return cdl;
	}
	public void setCdl(CountDownLatch cdl) {
		this.cdl = cdl;
	}
	public void yangguo() {
		System.out.println("我杨过搞掉了一个");
		cdl.countDown();
	}
	public void dugubaitian() {
		System.out.println("我独孤败天搞掉了一个");
		cdl.countDown();
	}
	
}
