package com.shipeiqimoshi;

public class Transfer {
	private LvBu lvbu = null;//������Ը����̬,����佫��,��������ʵ������

	public Transfer(LvBu lvbu) {
		super();
		this.lvbu = lvbu;
	}
	
	public void attack(String command){
		if("attack".equals(command)){
			lvbu.attack("����");
		}
	}
	
	public void fallBack(String command){
		if("fallback".equals(command)){
			lvbu.fallBack("����");
		}
	}
}
