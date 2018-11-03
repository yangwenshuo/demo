package com.shipeiqimoshi;

public class LvBu {
	
	public void attack(String command){
		if("进攻".equals(command)){
			System.out.println("吕布发起了进攻");
		}
	}
	
	public void fallBack(String command){
		if("撤退".equals(command)){
			System.out.println("吕布撤退了");
		}
	}
}
