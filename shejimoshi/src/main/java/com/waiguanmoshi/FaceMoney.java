package com.waiguanmoshi;

public class FaceMoney {
	
	public GuPiao gp1 = null;
	public GuPiao gp2 = null;
	public GuPiao gp3 = null;
	
	public FaceMoney(GuPiao gp1, GuPiao gp2, GuPiao gp3) {
		super();
		this.gp1 = gp1;
		this.gp2 = gp2;
		this.gp3 = gp3;
	}

	public void buyAll(){
		gp1.buy();
		gp2.buy();
		gp3.buy();
	}
	
	public void sellAll(){
		gp1.sell();
		gp2.sell();
		gp3.sell();
	}
}
