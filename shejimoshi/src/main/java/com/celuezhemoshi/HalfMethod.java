package com.celuezhemoshi;

public class HalfMethod implements PayMethod{

	@Override
	public double calculateMone(double initmoney) {
		// TODO Auto-generated method stub
		initmoney = initmoney * 0.5;
		return initmoney;
	}

}
