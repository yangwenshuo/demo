package com.guanchazhemoshi;

import java.util.ArrayList;

public class MiShu {
	private ArrayList<Emplyee> al = new ArrayList<>();
	
	public void addEmplyee(Emplyee e){
		al.add(e);
	}
	
	public void removeEmplyee(Emplyee e){
		al.remove(e);
	}
	
	public void tongZhiEmplyeeBossLaiLe(){
		
		System.out.println("�ϰ����˰� ��ȥ!");
		
		for (Emplyee emplyee : al) {
			emplyee.woQu();
		}
	}
}
