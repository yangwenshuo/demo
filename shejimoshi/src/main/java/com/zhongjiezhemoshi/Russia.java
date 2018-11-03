package com.zhongjiezhemoshi;

public class Russia extends Country{

	@Override
	public void beAttack(String weapon) {
		// TODO Auto-generated method stub
		System.out.println("俄罗斯受到了"+ weapon + "攻击");
	}

	@Override
	public void attack(String weapon) {
		// TODO Auto-generated method stub
		lhg.attack(this, "原子弹");
	}


}
