package com.fangwenzhemoshi;


//为什么这些设计模式都用接口的,因为接口也可以玩多态啊,而且只定义方法
//我们还是多用接口比较好,我们只要实现了这个接口的对象就好

//把这些东西抽象成接口主要是为了用多态

//重载与多态 方法的静态分派与静态分派
//比如一个方法是重载的,那么方法名是一样的,参数列表是不同的,我们可以根据传入的参数的类型不同在编译期就可以确定用哪个 这就方法的静态分派
//多态比如一个方法的参数是一个接口,如果是传递的是不同的实例对象的话,是可以根据重载的原理区分出到底传哪一个方法的,但是通常都会 用
//多态的特性用接口名当作形参,这样即使你传递的对象的类型是不同的,编译期也是看不出到底要用哪个方法的,只有到运行的时候才能确定,这个叫
//方法动态分派

public class Client {
	
		//访问者模式处理的问题是,多种类型的访问者访问多种类型的数据的扩展性问题.
	
		//首先从这个案例来讲,我们的账单对象有增加和减少,以后也可能扩展,查账的人现在只有老板和会计,以后也可能增加.
		//如果我们想增加一个税务局的人来查账,我们只需要新增一个类就可以了,如果我们不使用这个访问者模式,
		//那么我们就要先判断这个是老板还是会计,还是税务局的,就要加很多的if else,违反了开闭原则.
		//访问者的模式应用于多对多,这个是一个接口,下面很多的实例对象,那么也是一个接口,后面很多的实例对象,多个访问多个,
		//这样的多对多的形式就会产生很多个场景,我们需要判断出是什么场景,然后调用该场景相应的方法.
		//这样的话就会有很多的逻辑判断.
		//处理一对多的场景有 方法重载:一个方法名,对应里面传多个类型的参数,
		//还有一个方法场景是多态:一个方法名,一个参数名,传的时候传进去多个不同类型的子类实现类对象.
		
		//访问者模式就是用了方法重载和多态处理多对多的案例
	
	
		//必须一个是重载 一个是多态,不然出不来.
		//由于vister扩展的可能比较大,所以这个用多态.
	
		//在这个案例中:有两个接口,Account和Vister,每个的后面都有多种类型实现类.
		//这两个要联系一起肯定要互相有关联,vister里面有account的东西,account里面有vister的东西,
		//那么这两个都是多种的,怎么判断哪个是哪个呢  
		//vister的实现类中都有一个方法vister(),这个方法的参数是重载的,每一个重载的方法的参数都是一个accoutn的实现类.
		//account的实现类都有一个accept方法,里面传的是vister接口,是多态的.
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ZhangBen zb = new ZhangBen();
		
		InAccount ia1 = new InAccount(10);
		InAccount ia2 = new InAccount(20);
		InAccount ia3 = new InAccount(30);
		InAccount ia4 = new InAccount(40);
		
		OutAccount oa1 = new OutAccount(50);
		OutAccount oa2 = new OutAccount(60);
		
		zb.addAccount(ia1);
		zb.addAccount(ia2);
		zb.addAccount(ia3);
		zb.addAccount(ia4);
		
		zb.addAccount(oa1);
		zb.addAccount(oa2);
		//这里不涉及什么vister,我们把账单弄好就可以.
		
		//创建一个老板,来查账
		BossVister bv = new BossVister();
		zb.show(bv);
		System.out.println("--------------------------------------------");
		//创建一个会计对象,来查账
		KuaiJiVister kv = new KuaiJiVister();
		zb.show(kv);
	}

}
