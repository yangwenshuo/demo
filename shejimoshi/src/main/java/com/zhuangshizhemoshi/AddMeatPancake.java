package com.zhuangshizhemoshi;

public class AddMeatPancake implements DescPancake{

	private Pancake p = null;
	
	
	
	public AddMeatPancake(Pancake p) {
		super();
		this.p = p;
	}
	

	
	@Override
	public String showPrice() {
		// TODO Auto-generated method stub
		return p.showPrice() + "���ڸ������һ������,�۸�������3Ԫ";
	}
	
	
	
	@Override
	public String desc() {
		// TODO Auto-generated method stub
		return p.desc() + "�ָ�������������";
	}

}



