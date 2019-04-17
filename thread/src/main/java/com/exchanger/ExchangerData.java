package com.exchanger;

import java.util.concurrent.Exchanger;

public class ExchangerData {

	//这里面的泛型就是他们要交换什么东西
	private Exchanger<String> exs = new Exchanger<String>();


	//Exchanger这个东西是在连个线程之间交换数据的时候用的
	//所有要有两个线程都获取到这个exchanger对象
	//然后都调用exchange方法,就可以了


	public void sendBoll() {
		String name = "波尔";
		System.out.println("湖人队准备送出波尔");
		String exchange = null;
		
		try {
			exchange= exs.exchange(name);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("湖人队获得了" + exchange);
	}
	
	public void sendJMS() {
		String name = "詹姆斯";
		System.out.println("骑士准备送出詹姆斯");
		
		String exchange = null;
		
		try {
			exchange = exs.exchange(name);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("骑士获得了" + exchange);
	}
}
