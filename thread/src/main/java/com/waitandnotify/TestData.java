package com.waitandnotify;

public class TestData {
	
	
	//����ͨ�������־λ��������һ���̼߳��������Ի���.
	public int i = 0;
	
	
	
	
	//ע������������Ҫ��ͬ����,��ͬ��������ͬһ��������notify��wait
	public synchronized void method1() throws InterruptedException {
		
		if(i==1) {
			
			
			//��Ϊ����һ��ͬ����������������this��������this.wait();
			this.wait();
		}else {
			for(int i = 0;i<20;i++) {
				System.out.println("A��ӡ��������");
			}
			i=1;
			this.notify();
			
			//֪ͨ�����ϾͰ��Լ���wait��,�ȴ����˵�֪ͨ.
			this.wait();
			
			for(int i = 0;i<20;i++) {
				System.out.println("C��ӡ��������");
			}
		}
		
	}
	
	
	
	public synchronized void method2() throws InterruptedException {
		if(i==0) {
			this.wait();
		}else {
			for(int i = 0;i<10;i++) {
				System.out.println("B��ӡ��������");
			}
			i=0;
			this.notify();
		}
	}
	
	
	
}
