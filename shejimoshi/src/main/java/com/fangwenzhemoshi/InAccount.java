package com.fangwenzhemoshi;

public class InAccount implements Account{

	private int money;
	
	
	public int getMoney() {
		return money;
	}


	public void setMoney(int money) {
		this.money = money;
	}


	public InAccount(int money) {
		super();
		this.money = money;
	}


	@Override
	public void accept(Vister v) {
		// TODO Auto-generated method stub
		v.vister(this);
	}
}
