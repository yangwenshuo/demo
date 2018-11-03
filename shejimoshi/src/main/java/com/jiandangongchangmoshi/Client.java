package com.jiandangongchangmoshi;

public class Client {
	
	//还是那句话,设计模式中通常会抽象出一个顶层接口,这个接口主要是为了使用多态.
	//简单工厂模式主要是为了创建对应的对象,这些对象实现了同一个接口,就可以根据字符串来判断创建什么
	//利用了返回值的多态,返回值写的是animal,结果返回的是animal的实现类.
	
	//在所有用简单工厂的地方,都可以考虑用发射技术来去除which或if,解除分支判断带来的耦合.
	
	public static void main(String[] args) {
		Animal pig = AnimalFactory.getAnimal("pig");
		pig.eat();
		
		Animal cat  = AnimalFactory.getAnimal("cat");
		cat.eat();
		
		Animal tiger = AnimalFactory.getAnimal("tiger");
		tiger.eat();
	}
}
