package com.exchanger;

import java.util.concurrent.Exchanger;

public class ExchangerData {
	private Exchanger<String> exs = new Exchanger<String>();
	
	public void sendBoll() {
		String name = "����";
		System.out.println("���˶�׼���ͳ�����");
		String exchange = null;
		
		try {
			exchange= exs.exchange(name);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("���˶ӻ����" + exchange);
	}
	
	public void sendJMS() {
		String name = "ղķ˹";
		System.out.println("��ʿ׼���ͳ�ղķ˹");
		
		String exchange = null;
		
		try {
			exchange = exs.exchange(name);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("��ʿ�����" + exchange);
	}
}
