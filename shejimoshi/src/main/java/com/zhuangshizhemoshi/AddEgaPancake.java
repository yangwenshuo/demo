package com.zhuangshizhemoshi;

public class AddEgaPancake implements DescPancake{

	private Pancake p = null;
	
	
	
	public AddEgaPancake(Pancake p) {
		super();
		this.p = p;
	}



	@Override
	public String showPrice() {
		// TODO Auto-generated method stub
		return p.showPrice() + "���ڸ������һ������,�۸�������2Ԫ";
	}



	@Override
	public String desc() {
		// TODO Auto-generated method stub
		return p.desc() + "�ָ��������˼���";
	}

	
	

}
