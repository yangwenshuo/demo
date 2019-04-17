package com.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Client {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		//�ȴ���һ��Callable��ʵ�������,����������call�������ص���һ��user
		ACallable a = new ACallable();
		
		//Ȼ�󴴽�һ��FutureTask<User>  ��������call�����ķ���ֵ
		FutureTask<User> task = new FutureTask<User>(a);
		
		//Ȼ������task������������һ��thread������
		//!!!!!!!!!!!!!!!��task����thread�Ĳ�����������
		new Thread(task).start();
		//������߳���������൱�����ǿ���һ���첽�߳�,����һ����
		
		
		//�������߳����ڿ��Լ��������Լ�����
		for(int i = 0;i<10;i++) {
			System.out.println("������һ��,����ɶʱ��Ū��" + i);
		}
		
		long currentTimeMillis = System.currentTimeMillis();
		System.out.println("������ȥ���");
		
		
		//�����������̻߳���Ҫ�÷���ֵ�İ�,���ǵ���task��get������ȡ����ֵ
		//!!!!!!!!!!!!ע�����get������һ��������,����ȴ��߳�B�����ȡ����ֵ
		User user = task.get();   //������task��get()
		System.out.println(currentTimeMillis - System.currentTimeMillis());
		
	}
}
