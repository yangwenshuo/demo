package com.thread;

public class ThreadLocalUtil {

	 private static ThreadLocal<String> tl = new ThreadLocal<>();
	 
	 
	 //�������һ���߳����õ�,���ù���������
	 
	 public static void setThreadLocal(String s) {
		 tl.set(s);
	 }
	 
	 public static String getThreadLocal() {
		 String s = tl.get();
		 return s;
	 }
	
}
