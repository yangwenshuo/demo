package com.callable;

import java.util.concurrent.Callable;

public class ACallable implements Callable<User>{

	@Override
	public User call() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("准备去造个车,大约需要5秒中");
		Thread.currentThread().sleep(5000);
		System.out.println("造完返回");
		return new User("杨过",18);
	}

}
