package com.minglingmoshi;

public class Client {
	
		//命令模式的核心就是把命令看作一个对象.
	
	
		//命令模式:将一个请求封装为一个对象，从而使你可用不同的请求对客户进行参数化，对请求排队或记录请求日志，以及支持可撤销的操作
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//他能较容易的设计出一个命令队列,
		//可以较轻易的将命令写入日志,
		//允许cooker类拒绝请求
		//方便拓展命令类,不需要修改其他的代码
		//将命令的内容与命令的管理和维护分开了
		Cooker c = new Cooker();
		c.setAge(18);
		c.setName("西门吹雪");

		CookChikenCammod cookchicken1 = new CookChikenCammod();
		cookchicken1.cooker = c;
		//这一步是告诉服务员这道菜是是谁来做.
		//每一个命令
		CookChikenCammod cookchicken2 = new CookChikenCammod();
		cookchicken2.cooker = c;

		CookFishCammond cookfish1 = new CookFishCammond();
		cookfish1.cooker = c;
		CookFishCammond cookfish2 = new CookFishCammond();
		cookfish2.cooker = c;

		CookMeatCammod cookmeat1 = new CookMeatCammod();
		cookmeat1.cooker = c;
		CookMeatCammod cookmeat2 = new CookMeatCammod();
		cookmeat2.cooker = c;
		
		
		//我们将命令当作对象来管理,这样通过在对象里面添加内容,我们就可以实现各种功能.
		//waiter这个类也可以添加一些功能,是命令的管理类
		//通过这两个类我们实现的逻辑就可以很多了,计数,日志,撤销,拒绝等.
		Waiter w = new Waiter();
		w.setCammond(cookmeat2);
		w.setCammond(cookmeat1);
		w.setCammond(cookfish1);
		w.setCammond(cookfish2);
		w.setCammond(cookchicken1);
		w.setCammond(cookchicken2);
		
		
		w.notifyCooker();
	}

}
