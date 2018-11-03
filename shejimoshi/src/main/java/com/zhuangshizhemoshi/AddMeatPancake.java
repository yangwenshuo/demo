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
		return p.showPrice() + "现在给你加上一个肉松,价格增加了3元";
	}
	
	
	
	@Override
	public String desc() {
		// TODO Auto-generated method stub
		return p.desc() + "又给你增加了肉松";
	}

}



