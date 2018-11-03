package com.mobanfangfamoshi;

public class Client {
	//模板方法模式是需要利用到抽象类,就这样理解把,公共的东西放在这个抽象类的具体方法里,有特点的方法写成抽象方法,由子类去重写
	//具体方法里会调用这些抽象方法,这个设计模式还可以
	
	
	//重复的复杂的东西放在具体的方法里,这样我们就复用了复杂的结构,重复=易错+难改
	public static void main(String[] args) {
		DannyExam de = new DannyExam();
		de.testAll();
		LiMingExam lm = new LiMingExam();
		lm.testAll();
		
	}
}
