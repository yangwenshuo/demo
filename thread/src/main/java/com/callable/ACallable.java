package com.callable;

import java.util.concurrent.Callable;

public class ACallable implements Callable<User>{

	@Override
	public User call() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("׼��ȥ�����,��Լ��Ҫ5����");
		Thread.currentThread().sleep(5000);
		System.out.println("���귵��");
		return new User("���",18);
	}

}
