package com.gongchangmoshi;

public class Client {
	//原生的工厂模式是有一个工厂接口,猫有一个猫工厂,狗有一个狗工厂.
	//没啥子卵用,你想创建哪个对象的话,就需要先创建那个对象的工厂,再调用工厂的方法.
	//由于最上面是Ainmal和Factory,可以玩多态.
	
	//工厂模式的终极模式就是用反射,到底创建哪个对象有Classs.forName(xxxx)来创建对象,用户在client传进去一个字符串
	//工厂类就可以用Classs.forName(xxxx)来创建对象,无论创建什么对象,都不用改了,而且这个还可以把这个字符串搞到配置文件里.
	
	//工厂模式是有用的,对于一个对象的创建对外提供工厂的接口,外部不知道工厂内部的
	//实现只调用工厂的方法就可以,一旦需要修改东西我们只需要修改工厂的内容,而对外的接口
	//不变,那么外部也就不需要改变.
	
	//创建对象使不会对客户端暴露创建逻辑,并且使通过用一个共同的接口指向新创建的对象
	//让其子类自己决定实例化哪一个工厂类,工厂模式使其创建过程延迟到子类进行
	//优点
	//一个调用者创建一个对象,只要知道其名称就可以了,我们的工厂反射创建
	//扩展性高,增加一个产品,扩展一个工厂类就可以了
	//屏蔽产品的具体实现,调用者只关系产品的接口
	
	//缺点:一个产品一个工厂.类太多,增加了复杂度
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//看 玩多态
		Factory f = new BirdFactory();
		Animal bird = f.getAnimal();
		bird.work();
		System.out.println("-------------------");
		
		Factory f1 = new CatFactory();
		Animal cat = f1.getAnimal();
		cat.work();
		System.out.println("--------------------");
		
		Factory f2 = new DogFactory();
		Animal dog = f2.getAnimal();
		dog.work();
	}

}
