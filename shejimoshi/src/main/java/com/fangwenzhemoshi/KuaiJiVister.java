package com.fangwenzhemoshi;

public class KuaiJiVister implements Vister{

	@Override
	public void vister(OutAccount a) {
		// TODO Auto-generated method stub
		System.out.println("��Ʋ鿴��֧�����˵�,��ȥ"+a.getMoney()+"Ԫ!");
	}

	@Override
	public void vister(InAccount a) {
		// TODO Auto-generated method stub
		System.out.println("��Ʋ鿴��������˵�,����"+a.getMoney()+"Ԫ !");
	}

}
