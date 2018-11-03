package com.celuezhemoshi;

public class MethodContext {
	private PayMethod pm = null;

	public MethodContext(String type) {
		
		switch (type) {
		case "half":
			pm = new HalfMethod();
			break;
		case "free":
			pm = new FreeMethod();
			break;
		case "return":
			pm = new ReturnMoneyMethod();
			break;
		default:
			break;
		}
	}
	
	public double getFinalMoney(double initmoney){
		double finalmoney = this.pm.calculateMone(initmoney);
		return finalmoney;
	}
	

	
}
