package com.minglingmoshi;

public class Client {
	
		//����ģʽ�ĺ��ľ��ǰ������һ������.
	
	
		//����ģʽ:��һ�������װΪһ�����󣬴Ӷ�ʹ����ò�ͬ������Կͻ����в��������������Ŷӻ��¼������־���Լ�֧�ֿɳ����Ĳ���
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//���ܽ����׵���Ƴ�һ���������,
		//���Խ����׵Ľ�����д����־,
		//����cooker��ܾ�����
		//������չ������,����Ҫ�޸������Ĵ���
		//�����������������Ĺ����ά���ֿ���
		Cooker c = new Cooker();
		c.setAge(18);
		c.setName("���Ŵ�ѩ");

		CookChikenCammod cookchicken1 = new CookChikenCammod();
		cookchicken1.cooker = c;
		//��һ���Ǹ��߷���Ա���������˭����.
		//ÿһ������
		CookChikenCammod cookchicken2 = new CookChikenCammod();
		cookchicken2.cooker = c;

		CookFishCammond cookfish1 = new CookFishCammond();
		cookfish1.cooker = c;
		CookFishCammond cookfish2 = new CookFishCammond();
		cookfish2.cooker = c;

		CookMeatCammod cookmeat1 = new CookMeatCammod();
		cookmeat1.cooker = c;
		CookMeatCammod cookmeat2 = new CookMeatCammod();
		cookmeat2.cooker = c;
		
		
		//���ǽ����������������,����ͨ���ڶ��������������,���ǾͿ���ʵ�ָ��ֹ���.
		//waiter�����Ҳ�������һЩ����,������Ĺ�����
		//ͨ��������������ʵ�ֵ��߼��Ϳ��Ժܶ���,����,��־,����,�ܾ���.
		Waiter w = new Waiter();
		w.setCammond(cookmeat2);
		w.setCammond(cookmeat1);
		w.setCammond(cookfish1);
		w.setCammond(cookfish2);
		w.setCammond(cookchicken1);
		w.setCammond(cookchicken2);
		
		
		w.notifyCooker();
	}

}
