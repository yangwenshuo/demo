package com.betweenThreadShare;

public class Client {
	public static void main(String[] args) {
		
		//�������Ҫ����һ����Ա����!!!!!!!!!!!!!!!!
		
		
		
		
		
		//��ν���̼߳乲���ڴ�,�������ַ���,runable��Ūһ������
		//������  ����һ��runnableʵ�������
		
		//һ��runnable����������ܶ���߳���
		
		
		//����һ��ʵ���̼߳����ݹ���ķ�������
		//��һ�������������Ƕ����,  ��������ֱ�������ڲ���
		//�����̶߳�����ֱ��.start()���ַ�ʽ.
		
		//������������Ū�ǹ����˾ֲ�����,��Ҫ,��Ҫ��
		//�����߳��ﹲ�����ҪŪһ����Ա����!!!!!!!!!!!!!!!!!!!
		
		
		ARunable ar = new ARunable();
		new Thread(ar).start();
		new Thread(ar).start();
		new Thread(ar).start();
		new Thread(ar).start();
	}
}
