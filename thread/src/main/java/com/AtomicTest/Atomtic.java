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
		
		
		
		
		
		
        User u = new User("���", "18", "��");
		System.out.println(u);
		//atomicReference�Ͷ���󶨾���atomicreference�Ĺ������Ǹ�����
		AtomicReference<User> yg = new AtomicReference<User>(u);
		User u1 = yg.get();
		
		User u2 = new User("���", "80", "��");
		
		//ע������������з���ֵ��,����ֵ��һ������,���Ը���true����false�ж�
		//�ɹ�û��
		System.out.println(yg.compareAndSet(u1, u2));
		//�����ڶ�����˵,�����compareandset(u1,u2)��˵,����
		//��u2�����ݸ���u1,�͵�ַ�޹�,���ó�u2�����ݸ�u1.
		
		//���refer����get�����Ķ���ĵ�ַ������ȥʱ��ĵ�ַ��һ����
		System.out.println(yg.get());
		
	}
}
