 package com.zhongjiezhemoshi;

public class Client {
	public static void main(String[] args) {
		
		
		//中介者模式的核心是:联合国对象种保存所有对象的地址,他能够找到任何对象的地址.
		//任何国家对象都保存着联合国对象的地址,他们都能找到联合国.
		//国家有的方法联合国都有,比如国家的attack方法其实是调用了他内部的联合国对象的attach方法.
		
		
		
		//中介者模式:用一个中介对象来封装一系列的对象交互.中介者使各对象不需要显式的互相引用, 从而使其耦合松散
		//而且可以独立的改变他们之间的交互
		LianHeGuoMediator lhg = new LianHeGuoMediator();
		America usa = new America();
		Russia russia = new Russia();
		//中介者模式很容易被应用,也很容易被误用,当系统出现了多对多交互复杂的对象群时,不要急于使用中介者模式,分时是否适合
		//中介者的出现大大减少了各个类之间的耦合,
		//由于中介者控制的集中化,于是就把交互复杂性变成了中介者的复杂性,这就使的中介者十分的复杂,一旦中介者除了问题,
		//那么就全玩完了.
		lhg.setRussia(russia);
		lhg.setUsa(usa);
		//中介者模式一般用于一组对象以定义良好但是复杂的方式进行通信的场合,比如计算器,上面有加减乘除等控件和数字控件
		//他们之间相互通信,这时我们就可以用中介者模式,满足上一句话.
		usa.setLhg(lhg);
		russia.setLhg(lhg);
		
		usa.attack("战斧导弹");
		russia.attack("原子弹");
	}
	//抽象类中的成员参数最好是protect的，因为要给子类继承。
}
