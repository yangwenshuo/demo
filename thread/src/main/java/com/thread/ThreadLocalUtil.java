package com.thread;

public class ThreadLocalUtil {

	 private static ThreadLocal<String> tl = new ThreadLocal<>();
	 
	 
	 //这个就是一个线程中用的,不用管锁不锁的
	 
	 public static void setThreadLocal(String s) {
		 tl.set(s);
	 }
	 
	 public static String getThreadLocal() {
		 String s = tl.get();
		 return s;
	 }
	
}
