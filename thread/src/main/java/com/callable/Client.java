package com.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Client {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		//先创建一个Callable的实现类对象,我这个里面的call方法返回的是一个user
		ACallable a = new ACallable();
		
		//然后创建一个FutureTask<User>  泛型是你call方法的返回值
		FutureTask<User> task = new FutureTask<User>(a);
		
		//然后把这个task当作参数创建一个thread并启动
		//!!!!!!!!!!!!!!!把task当作thread的参数给启动了
		new Thread(task).start();
		//当这个线程启动后就相当于我们开了一个异步线程,在做一件事
		
		
		//我们主线程现在可以继续的做自己的事
		for(int i = 0;i<10;i++) {
			System.out.println("我玩了一次,看你啥时候弄完" + i);
		}
		
		long currentTimeMillis = System.currentTimeMillis();
		System.out.println("我现在去瞅瞅");
		
		
		//但是我们主线程还是要用返回值的啊,我们调用task的get方法获取返回值
		//!!!!!!!!!!!!注意这个get方法是一个阻塞的,他会等待线程B跑完获取返回值
		User user = task.get();   //这里是task来get()
		System.out.println(currentTimeMillis - System.currentTimeMillis());
		
	}
}
