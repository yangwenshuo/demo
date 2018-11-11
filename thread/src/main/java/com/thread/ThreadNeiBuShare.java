package com.thread;

public class ThreadNeiBuShare {
	public static void main(String[] args) {
		
		
		ThreadLocalUtil.setThreadLocal("Ñî¹ý");
		
		for (int i = 0; i < 30; i++) {
			System.out.println(i);
		}
		
		System.out.println(ThreadLocalUtil.getThreadLocal());
	}
}
