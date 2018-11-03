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
		return p.showPrice() + "现在给你加上一个鸡蛋,价格增加了2元";
	}



	@Override
	public String desc() {
		// TODO Auto-generated method stub
		return p.desc() + "又给你增加了鸡蛋";
	}

	
	

}
