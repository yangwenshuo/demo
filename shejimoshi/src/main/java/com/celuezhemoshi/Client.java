package com.celuezhemoshi;

public class Client {
	public static void main(String[] args) {

		//������ģʽ�ͼ򵥹���ģʽ�̫��,���ǿ�������㷨�ĸı�,�����ǻ�������
		
		//��ʵ������Ҳ�ǻ�����,ֻ���������ڷ��ص�client��,���Ǳ����������ڹ�����ĳ�Ա����
		
		//Ȼ�����ṩһ������,���ù�����Ķ���,���÷���,������������������ʲô����,������
		//��ֻ�������Լ�������һ�������ڹ�����context����(�����и��ַ���)
		//Ȼ�����context��getxxx�����Ϳ��Ի����Ҫ�Ķ���,�ַ�����ͬ,�����ͬ
		//���Ҳ�Ƕ�̬.
		
		
		// ���������Ķ���,ͨ���ַ������ܿ��ƴ����ĸ�����
		MethodContext mc = new MethodContext("half");
		double halfmoney = mc.getFinalMoney(400);
		System.out.println("��۵�Ǯ��:" + halfmoney);
		
		MethodContext mc1 = new MethodContext("return");
		double returnmoney = mc1.getFinalMoney(400);
		System.out.println("������Ǯ��:" + returnmoney);
		
		MethodContext mc2 = new MethodContext("free");
		double freemoney = mc2.getFinalMoney(400);
		System.out.println("���M��Ǯ��:" + freemoney);

	}
}
