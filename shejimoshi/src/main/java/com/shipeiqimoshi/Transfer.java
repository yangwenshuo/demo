package com.shipeiqimoshi;

public class Transfer {
	private LvBu lvbu = null;//这里可以搞个多态,搞个武将类,吕布当作实例对象

	public Transfer(LvBu lvbu) {
		super();
		this.lvbu = lvbu;
	}
	
	public void attack(String command){
		if("attack".equals(command)){
			lvbu.attack("进攻");
		}
	}
	
	public void fallBack(String command){
		if("fallback".equals(command)){
			lvbu.fallBack("撤退");
		}
	}
}
