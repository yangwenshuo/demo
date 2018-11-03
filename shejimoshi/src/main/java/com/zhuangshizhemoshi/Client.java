package com.zhuangshizhemoshi;

public class Client {
	//装饰者模式动态的给一个对象添加一些额外的功能,就增加功能来说,装饰者模式比子类更加灵活
	
	
	//装饰者模式是可以动态组合的,装饰类和被装饰类可以动态组合.
	//装饰者模式主要是为了给一个类增加功能,也就是说装饰者模式可以给原有类增加一些新的方法,他强调的是给一个类增加功能而且不用继承
	//而代理模式是强调的是,在你想访问一个类的时候,我跟你加个代理,控制你对这个对象的方法的访问,让不让你访问,让你怎么访问,而不是为
	//了增加新的功能.
	
	//装饰者模式的装饰类是需要能完全替换被装饰类的,也就是被装饰的是杯子,你给他装饰成了红色的杯子,这个红色的杯子是要完全能替换
	//使用杯中的保温,装水功能的,你只是做了功能的添加,以前有的功能装饰者类完全有,
	//这样就可以看出装饰者模式的好处了,他可以给一个对象包装起来增加功能还不用继承.
	//而代理模式就不一样了,有的情形我都不让你访问到被代理者,直接就给你return了,我把被代理者的功能的实现都给你隐藏了,你还完全替换个毛
	
	//装饰者模式在java中的应用比如:BufferedOutPutStream bfs = new BufferedOutPutStream(new FileOutPutStream);
	//经查询BufferedOutPutStream和FileOutPutStream都是继承了OutPutStream,而BufferedOutPutStream装饰了
	//FileOutPutStream,并且提供了一些FileOutPutStream没有的方法.
	
	//代理模式是不会改变被代理对象的接口的,被代理对象有什么接口他就有什么接口,
	//因为代理对象和被代理对象都是实现了同一个接口,所以动态代理创建对象时要获取
	//被代理对象的接口啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊
	//而适配器模式就可以改变被适配对象的接口,他俩也不是实现了同一个接口,他就是
	//对一些不符合接口的类进行改造的,咋能跟你一样,你接口和现在规范不匹配了.
	//我用适配器改造你
	//而装饰者模式其实和代理模式差不多也是继承了同一个接口,但是装饰者模式强调
	//的是对接口方法的增强,而代理模式强调的是对你的访问的对象加上一层访问控制
	//......但是我们的动态代理好像就是增强..........
	
	
	
	
	//注意:加煎蛋的饼,加火腿的饼这些装饰类,和煎饼,手抓饼这些被装饰的实际类是可以动态组合的,
	//注意装饰类,是加鸡蛋的饼,加火腿的饼,并没有特指哪一种饼,所以这些类的内部是可以放任意饼用来
	//动态组合的.    注意装饰者类的接口是继承自饼接口的,这样装饰者与本体就是一样的了
	
	//实现就是把装饰者类内部搞一个饼对象,然后装饰者对象调方法的时候想调用饼对象的方法,然后再给这个
	//方法加一些功能
	
	
	//可见装饰者模式主要是为了给类中的方法做扩展的,又不想重写,因为这个可以动态组合.
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		APancake a = new APancake();
		BPancake b = new BPancake();
		
		//有两种饼,两种可选增加的食物,现在我们玩一下动态的组合,组合出四种饼
		
		//现在我们搞出一个加鸡蛋的煎饼
		AddEgaPancake aep = new AddEgaPancake(a);
		System.out.println(aep.showPrice());
		System.out.println(aep.desc());
		System.out.println("--------------------------");
		
		//现在我们还是用这个对象,组合出一个加肉松的煎饼
		AddMeatPancake amp = new AddMeatPancake(a);
		System.out.println(amp.showPrice());
		System.out.println(amp.desc());
		System.out.println("--------------------------");
		
		//给装饰者类传进去饼类是什么饼主体
		
		//现在我们搞出一个加了鸡蛋手抓饼
		AddEgaPancake aep1 = new AddEgaPancake(b);
		System.out.println(aep1.showPrice());
		System.out.println(aep1.desc());
		System.out.println("--------------------------");
		
		//现在我们搞出一个加肉松的手抓饼   看到了吧,装饰着和内部类可以互相组合的
		AddMeatPancake amp1 = new AddMeatPancake(b);
		System.out.println(amp1.showPrice());
		System.out.println(amp1.desc());
	}
}
