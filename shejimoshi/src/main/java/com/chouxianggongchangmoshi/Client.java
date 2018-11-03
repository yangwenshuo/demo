package com.chouxianggongchangmoshi;


public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		///也就是普通的工厂只能创建一种对象,也就只有一个createxxx方法
		///而抽象工厂有多个函数,可以创建不同的对象,
		//只要工厂变了,工厂创建出来的对象也就变了
		///
		
		
		//和普通工厂的区别的就是抽象工厂创建对象的方法是多个
		//普通工厂创建对象的方法是一个.
		//五个诺克萨斯的英雄换成五个德玛西亚的英雄,你只需要
		//把工厂对象改了,后面创建的英雄都是不一样的.
		
		
		
		//工厂模式都是为了创建对象而设计的
		
		//通过反射可以去除所有工厂模式的switch,
		
		//抽象工厂模式:提供一个创建一系列相关或相互依赖对象的接口,而无限指定他们具体的类.
		
		//抽象工厂模式的应用场景,换数据库,一开始是一个mysql数据库,换成别的,也是通过换个工厂名字就行了
		
		//抽象工厂模式是和工厂模式有关联的,工厂模式就是一个类对应一个工厂,创建这个类的对象之前先创建工厂,用工厂创建该类的对象.
		//而抽象工厂模式的工厂不是创建一个对象,而是内部可以创建很多个对象,而且不同的工厂创建的那么多的类是关系的,如本例
		//工厂里创建的三种英雄有共同父类,看看就明白了,反正就是玩的多态.
		
		//不完美的地方就是要是想增加一个打野英雄,这两个工厂类都需要修改.
		
		//经过下面的操作我们用德玛工厂创建了德玛西亚的,三路英雄,并调用了德玛三路英雄的技能,
		//如果我不想用德玛的英雄了,把这个demafacory换成诺克factory就可以了.
		//而且修改这个工厂对象我也可以用反射来做,直接从配置文件里读取字符串创建工厂对象,根本就不需要修改代码就能完成英雄们的切换.
		
		IFactory factory = new NuoKeFactory();
		ADHero adc = factory.createADHero();
		adc.QJiNeng();
		adc.WJiNeng();
		adc.EJiNeng();
		adc.RJiNeng();
		MidHero mid = factory.createMidHero();
		mid.QJiNeng();
		mid.WJiNeng();
		mid.EJiNeng();
		mid.RJiNeng();
		TopHero top = factory.createTopHero();
		top.QJiNeng();
		top.WJiNeng();
		top.EJiNeng();
		top.RJiNeng();	
	}

}
