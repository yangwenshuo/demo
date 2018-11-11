package com.betweenThreadShare;

public class Client {
	public static void main(String[] args) {
		
		//共享变量要共享一个成员变量!!!!!!!!!!!!!!!!
		
		
		
		
		
		//所谓的线程间共享内存,就是这种方案,runable里弄一个变量
		//其他的  创建一个runnable实现类对象
		
		//一个runnable对象给塞到很多的线程里
		
		
		//还有一种实行线程间内容共享的方法就是
		//第一次我们那样想是对象的,  就是那种直接匿名内部类
		//创建线程对象并且直接.start()那种方式.
		
		//但是我们那样弄是共享了局部变量,不要,你要想
		//在主线程里共享变量要弄一个成员变量!!!!!!!!!!!!!!!!!!!
		
		
		ARunable ar = new ARunable();
		new Thread(ar).start();
		new Thread(ar).start();
		new Thread(ar).start();
		new Thread(ar).start();
	}
}
