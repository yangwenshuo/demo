package com.zhuangtaimoshi;

	//state的实现类主要有两个职责,1,处理本状态下的事情,2,从本状态过度到其他状态

	//这里用到了这个关系,一个类的成员变量是一个对象,这个对象有个方法的参数是这个类的对象,所有在这个类内部调用这个成员变量对象的
	//方法的时候就是   成员变量对象.method(this),这两个类就关联了,他能用它,他也能用他.
	//我们称为双蛇关系.




public class Client {
	public static void main(String[] args) {
		//状态模式:当一个对象的内在状态改变时允许改变其行为,这个对象看起来像改变了类.
		//这个状态模式是这样的,当这个对象处于不同的状态时,他的方法是不同的.
		//万剑一有三个状态,玉清,上清,太清,我们有状态跳转方法,可以调用方法跳转状态,这样的话就不用switch判断到底处于什么状态
		//然后往哪里跳了.如果在太清后面增加一个武破虚空状态的话就创建这个类,然后改下太清类就可以了,switch不用改.
		//同时,万剑一在不同状态的时候调用方法是不同的效果
		
		WanJianYi wjy = new WanJianYi();
		wjy.setState(new YuQingState());
		//此时是玉清状态,我们看看万剑一在玉清模式能做些什么
		wjy.testQuWu();
		wjy.testShenJianYuLeiZhenJue();
		wjy.testZhuXianJianZhen();
		wjy.testXiuLan();
		//上面一行万剑一修到了上清状态,我们看看上清状态,他能做些什么
		wjy.testQuWu();
		wjy.testShenJianYuLeiZhenJue();
		wjy.testZhuXianJianZhen();
		wjy.testXiuLan();
		//上面一行万剑一修到了太清状态,我们看看太清状态,他能做些什么
		wjy.testQuWu();
		wjy.testShenJianYuLeiZhenJue();
		wjy.testZhuXianJianZhen();
		wjy.testXiuLan();
	}
}
