package com.dailimoshi;

public class MiShu implements Person{

	private Person p = null;
	private String xinqing = "��";
	
	
	
	public Person getP() {
		return p;
	}

	public void setP(Person p) {
		this.p = p;
	}

	@Override
	public void meet() {
		// TODO Auto-generated method stub
		System.out.println("��������,�������������,���������������Ҿ����㿴���ϰ�,������鲻�þͲ�Ȼ�㿴��");
		if(this.xinqing.equals("��")){
			p.meet();
		}else{
			System.out.println("�������鲻��,�����㿴���ϰ�");
		}
		
	}

}
