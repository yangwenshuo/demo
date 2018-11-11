package com.exchanger;

import java.util.concurrent.Exchanger;

public class ExchangerData {
	private Exchanger<String> exs = new Exchanger<String>();
	
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
