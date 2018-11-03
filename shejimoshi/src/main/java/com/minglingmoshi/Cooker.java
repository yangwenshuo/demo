package com.minglingmoshi;

public class Cooker {
	private String name;
	private int age;
	
	public void cookChiken(){
		System.out.println("厨师"+this.name+"在做鸡");
	}
	
	public void cookMeat(){
		System.out.println("厨师"+this.name+"在做红烧肉");
	}
	
	public void cookFish(){
		System.out.println("厨师"+this.name+"在做红烧鱼");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
}
