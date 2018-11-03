package com.zhongjiezhemoshi;

public class America extends Country{

	@Override
	public void beAttack(String weapon) {
		// TODO Auto-generated method stub
		System.out.println("美国受到了"+ weapon + "攻击");
	}

	@Override
	public void attack(String weapon) {
		// TODO Auto-generated method stub
		lhg.attack(this, weapon);
	}


}
