package com.yuanxingmoshi;

public class CloneTest implements Cloneable{
	private String name;
	
	public CloneTest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CloneTest(String name) {
		super();
		this.name = name;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
