package com.celuezhemoshi;

public class ReturnMoneyMethod implements PayMethod{

	@Override
	public double calculateMone(double initmoney) {
		if (initmoney>300) {
			initmoney = initmoney - 50;
		}
		return initmoney;
	}

}
