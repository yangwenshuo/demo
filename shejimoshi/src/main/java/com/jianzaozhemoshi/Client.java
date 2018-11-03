package com.jianzaozhemoshi;

import java.util.ArrayList;

	//对外屏蔽创建过程

	//建造者模式是在当创建复杂对象的算法应该独立于该对象的组成部分时的设计模式.
public class Client {
	//建造者模式:建造者主要有三个东西,被建造的东西,建造者,和指挥官
	//建造者的内部有一个成员变量private Product p = new Product();他内部还有很多方法用来给这个product赋值
	//建造者还有一个方法return他内部的对象
	//而指挥官就去搞一个建造者对象,调用他的赋值的方法,调完之后建造者内部的对象就有内容了
	//最后在让建造者return这个product就可以了. 
	
	//好处就是builder可以扩展,当你的cpu 硬盘换了的时候,只要增加builder类就可以了
	
	
	public static void main(String[] args) {
		//比如我们去肯德基买30元套餐,套餐的内容经常变,这个套餐指挥者,指挥者告诉厨师这个套餐
		//有什么,厨师做好端上来,如果套餐变了 ,指挥者换一批厨师就可以了
		//但是对外是看不出来的,比如这里我们可以把创建bulder的过程放在commander里面,然后
		//根据配置文件决定创建哪个电脑,然后用户就什么也看不到了,就看到指挥者给了他一个电脑
		//commander调用方法,builder就会创建产品,产品会保存他们内部,调用方法管他们要
		Commander c = new Commander();
		Builder dellb = new DellComputerBuilder();
		c.commandBuilerToBulid(dellb);
		Product p = dellb.getProduct();
		ArrayList<String> cpart = p.cpart;
		for (String string : cpart) {
			System.out.println(string);
		}
		
		
		//现在电脑换成惠普了,我们就换个builder就可以了
		Builder hpb = new HpComputerBuilder();
		
		c.commandBuilerToBulid(hpb);
		
		Product p1 = hpb.getProduct();
		ArrayList<String> cpart2 = p1.cpart;
		for (String string : cpart2) {
			System.out.println(string);
		}
	}
	
}
