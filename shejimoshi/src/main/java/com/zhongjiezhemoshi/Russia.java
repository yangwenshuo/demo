package com.zhongjiezhemoshi;

public class Russia extends Country{

	@Override
	public void beAttack(String weapon) {
		// TODO Auto-generated method stub
		System.out.println("����˹�ܵ���"+ weapon + "����");
	}

	@Override
	public void attack(String weapon) {
		// TODO Auto-generated method stub
		lhg.attack(this, "ԭ�ӵ�");
	}


}
