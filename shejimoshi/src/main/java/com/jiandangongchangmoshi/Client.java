package com.jiandangongchangmoshi;

public class Client {
	
	//�����Ǿ仰,���ģʽ��ͨ��������һ������ӿ�,����ӿ���Ҫ��Ϊ��ʹ�ö�̬.
	//�򵥹���ģʽ��Ҫ��Ϊ�˴�����Ӧ�Ķ���,��Щ����ʵ����ͬһ���ӿ�,�Ϳ��Ը����ַ������жϴ���ʲô
	//�����˷���ֵ�Ķ�̬,����ֵд����animal,������ص���animal��ʵ����.
	
	//�������ü򵥹����ĵط�,�����Կ����÷��似����ȥ��which��if,�����֧�жϴ��������.
	
	public static void main(String[] args) {
		Animal pig = AnimalFactory.getAnimal("pig");
		pig.eat();
		
		Animal cat  = AnimalFactory.getAnimal("cat");
		cat.eat();
		
		Animal tiger = AnimalFactory.getAnimal("tiger");
		tiger.eat();
	}
}
