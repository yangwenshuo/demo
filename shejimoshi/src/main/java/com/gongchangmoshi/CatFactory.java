package com.gongchangmoshi;

public class CatFactory implements Factory{

	@Override
	public Animal getAnimal() {
		// TODO Auto-generated method stub
		return new Cat();
	}
	
}
