package com.zhongjiezhemoshi;

public abstract class Country {
	protected LianHeGuoMediator lhg;
	
	public abstract void beAttack(String weapon);
	public abstract void attack(String weapon);
	
	public LianHeGuoMediator getLhg() {
		return lhg;
	}
	public void setLhg(LianHeGuoMediator lhg) {
		this.lhg = lhg;
	}
	
	

}
