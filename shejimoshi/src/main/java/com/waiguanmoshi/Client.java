package com.waiguanmoshi;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//���ģʽ:���ǰ�ϵ�в���������һ���������,��ֻ��֪����������,������ô���,ʵ�����������Ҫ���ٶ���,��
		//���ٷ���,�㶼����Ҫ��,����ӿڱ��
		FaceMoney fm = new FaceMoney(new GuPiao1(), new GuPiao2(), new GuPiao3());
		
		
		//��������Ӷ���,�ⲿֻ֪����������������,�ڲ�������ô����������֪��,���ĳ�Ա�������кܶ����.
		//�����ṩ����Щ����Ĺ������ģʽ.
		fm.buyAll();
		fm.sellAll();
	}

}
