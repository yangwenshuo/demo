package com.jianzaozhemoshi;

import java.util.ArrayList;

	//�������δ�������

	//������ģʽ���ڵ��������Ӷ�����㷨Ӧ�ö����ڸö������ɲ���ʱ�����ģʽ.
public class Client {
	//������ģʽ:��������Ҫ����������,������Ķ���,������,��ָ�ӹ�
	//�����ߵ��ڲ���һ����Ա����private Product p = new Product();���ڲ����кܶ෽�����������product��ֵ
	//�����߻���һ������return���ڲ��Ķ���
	//��ָ�ӹپ�ȥ��һ�������߶���,�������ĸ�ֵ�ķ���,����֮�������ڲ��Ķ������������
	//������ý�����return���product�Ϳ�����. 
	
	//�ô�����builder������չ,�����cpu Ӳ�̻��˵�ʱ��,ֻҪ����builder��Ϳ�����
	
	
	public static void main(String[] args) {
		//��������ȥ�ϵ»���30Ԫ�ײ�,�ײ͵����ݾ�����,����ײ�ָ����,ָ���߸��߳�ʦ����ײ�
		//��ʲô,��ʦ���ö�����,����ײͱ��� ,ָ���߻�һ����ʦ�Ϳ�����
		//���Ƕ����ǿ���������,�����������ǿ��԰Ѵ���bulder�Ĺ��̷���commander����,Ȼ��
		//���������ļ����������ĸ�����,Ȼ���û���ʲôҲ��������,�Ϳ���ָ���߸�����һ������
		//commander���÷���,builder�ͻᴴ����Ʒ,��Ʒ�ᱣ�������ڲ�,���÷���������Ҫ
		Commander c = new Commander();
		Builder dellb = new DellComputerBuilder();
		c.commandBuilerToBulid(dellb);
		Product p = dellb.getProduct();
		ArrayList<String> cpart = p.cpart;
		for (String string : cpart) {
			System.out.println(string);
		}
		
		
		//���ڵ��Ի��ɻ�����,���Ǿͻ���builder�Ϳ�����
		Builder hpb = new HpComputerBuilder();
		
		c.commandBuilerToBulid(hpb);
		
		Product p1 = hpb.getProduct();
		ArrayList<String> cpart2 = p1.cpart;
		for (String string : cpart2) {
			System.out.println(string);
		}
	}
	
}
