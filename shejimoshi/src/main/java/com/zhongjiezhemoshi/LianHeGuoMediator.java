package com.zhongjiezhemoshi;

public class LianHeGuoMediator {
	//���Ϲ��н����˽����й��ҵ���Ϣ���������еĹ��Ҷ������е�ַ��Ϣ��
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
