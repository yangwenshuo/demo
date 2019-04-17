package com.AtomicTest;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Atomtic {
	public static void main(String[] args) {
		AtomicInteger ai = new AtomicInteger(1000);
		System.out.println(ai.get());
		System.out.println(ai.incrementAndGet());
		System.out.println(ai.addAndGet(10));
		System.out.println(ai.compareAndSet(1011, 4));
		System.out.println(ai.get());
		
		
		
		
		
		
        User u = new User("杨过", "18", "男");
		System.out.println(u);
		//atomicReference和对象绑定就用atomicreference的构造变成那个对象
		AtomicReference<User> yg = new AtomicReference<User>(u);
		User u1 = yg.get();
		
		User u2 = new User("杨过", "80", "男");
		
		//注意这个函数是有返回值的,返回值是一个布尔,可以根据true还是false判断
		//成功没有
		System.out.println(yg.compareAndSet(u1, u2));
		//而对于对象来说,他这个compareandset(u1,u2)来说,就是
		//把u2的内容赋给u1,和地址无关,会拿出u2的内容给u1.
		
		//你从refer对象get出来的对象的地址和你存进去时候的地址是一样的
		System.out.println(yg.get());
		
	}
}
