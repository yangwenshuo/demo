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
		System.out.println("����������һ��");
		cdl.countDown();
	}
	public void dugubaitian() {
		System.out.println("�Ҷ��°�������һ��");
		cdl.countDown();
	}
	
}
