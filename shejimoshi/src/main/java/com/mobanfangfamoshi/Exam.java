package com.mobanfangfamoshi;

public abstract class Exam {
	public abstract String text1();
	public abstract String text2();
	public abstract String text3();
	
	public void testAll(){
		String test1 = "第一题你选择什么:";
		System.out.println(test1 + this.text1());
		System.out.println("--------------");
		
		String test2 = "第二题你选择什么:";
		System.out.println(test2 + this.text2());
		System.out.println("--------------");
		
		String test3 = "第三题你选择什么:";
		System.out.println(test3 + this.text1());
	}
}
