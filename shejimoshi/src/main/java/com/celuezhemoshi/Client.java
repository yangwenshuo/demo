package com.celuezhemoshi;

public class Client {
	public static void main(String[] args) {

		//策略者模式和简单工厂模式差不太多,这个强调的是算法的改变,而不是换个对象
		
		//其实本质上也是换对象,只不过对象不在返回到client了,而是保存在类似于工厂类的成员变量
		
		//然后在提供一个方法,调用工厂里的对象,调用方法,对于外面他看不到有什么对象,对外面
		//他只看到了自己创建了一个类似于工厂的context对象(参数有个字符串)
		//然后调用context的getxxx方法就可以获得想要的东西,字符串不同,结果不同
		//玩的也是多态.
		
		
		// 创建上下文对象,通过字符串就能控制创建哪个对象
		MethodContext mc = new MethodContext("half");
		double halfmoney = mc.getFinalMoney(400);
		System.out.println("半价的钱是:" + halfmoney);
		
		MethodContext mc1 = new MethodContext("return");
		double returnmoney = mc1.getFinalMoney(400);
		System.out.println("返利的钱是:" + returnmoney);
		
		MethodContext mc2 = new MethodContext("free");
		double freemoney = mc2.getFinalMoney(400);
		System.out.println("免費的钱是:" + freemoney);

	}
}
