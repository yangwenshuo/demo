package com.minglingmoshi;

import java.util.ArrayList;

public class Waiter {

	private ArrayList<CookCammond> al = new ArrayList<CookCammond>();
	
	public void setCammond(CookCammond cc){
		al.add(cc);
	}
	
	public void notifyCooker(){
		for (CookCammond cookCammond : al) {
			//ע������,CookCammond����Ȼ�ǳ�����,���Ǵ���ʱ��������ʵ�������,���õ���ʵ������д���
			//����
			cookCammond.excute();
		}
	}
	
	
}
