package com.fangwenzhemoshi;

public class BossVister implements Vister{

	@Override
	public void vister(OutAccount a) {
		// TODO Auto-generated method stub
		
		System.out.println("�ϰ�鿴��֧�����˵�,����"+a.getMoney()+"����!");
	}

	@Override
	public void vister(InAccount a) {
		// TODO Auto-generated method stub
		System.out.println("�ϰ�鿴��������˵�,����"+a.getMoney()+"����!");
	}

}
