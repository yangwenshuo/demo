package com.minglingmoshi;

public class Cooker {
	private String name;
	private int age;
	
	public void cookChiken(){
		System.out.println("��ʦ"+this.name+"������");
	}
	
	public void cookMeat(){
		System.out.println("��ʦ"+this.name+"����������");
	}
	
	public void cookFish(){
		System.out.println("��ʦ"+this.name+"����������");
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
