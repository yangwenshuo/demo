package com.yuanxingmoshi;

public class Test {

	public static void main(String[] args) throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		
	//原型类要实现Cloneable接口.`
		
		//原型模式:就是在创建对象的时候不是用new 类名();创建,而是克隆一个创建好的对象来创建,内容和这个模板对象一样.
		//这样创建就不需要知道创建这个对象的具体细节,他有多少参数都不需要知道.
		//隐藏了创建的细节,而且据说效率还会提高,动态的获得一个已经创建好的对象.
		
		//具体的实现方式就是原型类要实现Cloneable接口,并且重写clone()方法,但是注意这个clone方法不是这个接口的方法,
		//而是object的方法.
		
		
		//但是注意java中的clone是浅复制,也就是如果这个对象中的成员变量是引用类型的话,那么这个引用类型的复制只是把地址复制了一份,
		//也就是这个复制出来的对象和原对象的这个成员变量指向的是同一个地址,java默认clone()就是这种浅复制.
		//如果你想实现深复制的话就要去判断成员变量是不是引用类型,引用类型的话就得调用这个成员变量的clone方法,他还得实现了cloneable接口才行
		//或者用序列化和反序列化来实现,把这个对象序列化了,然后再反序列化出来,那么得到的就是一个深拷贝的对象.
		
		                                             
		CloneTest ct = new CloneTest("杨过");
		CloneTest ct1 = (CloneTest)ct.clone();
		
		System.out.println(ct.getName());
		System.out.println(ct1.getName());
	}

}
