package com.waiguanmoshi;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//外观模式:就是把系列操作隐藏在一个外观类中,你只需知道这个外观类,具体怎么玩的,实现这个功能需要多少对象,调
		//多少方法,你都不需要管,面向接口编程
		FaceMoney fm = new FaceMoney(new GuPiao1(), new GuPiao2(), new GuPiao3());
		
		
		//就这个例子而言,外部只知道他有这两个方法,内部到底怎么回事他并不知道,他的成员变量里有很多对象.
		//对外提供了这些对象的管理外观模式.
		fm.buyAll();
		fm.sellAll();
	}

}
