package com.zhongjiezhemoshi;

public class LianHeGuoMediator {
	//联合国中介者了解所有国家的信息，所以所有的国家都在这有地址信息。
	private Russia russia;
	private America usa;

	public void attack(Country c,String weapon) {

		if (c == usa) {
			russia.beAttack(weapon);
		}else if(c == russia){
			usa.beAttack(weapon);
		}
		
		
	}

	public Russia getRussia() {
		return russia;
	}

	public void setRussia(Russia russia) {
		this.russia = russia;
	}

	public America getUsa() {
		return usa;
	}

	public void setUsa(America usa) {
		this.usa = usa;
	}
	
	

}
