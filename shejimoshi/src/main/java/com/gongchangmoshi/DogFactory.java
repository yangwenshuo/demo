package com.gongchangmoshi;

public class DogFactory implements Factory{

	@Override
	public Animal getAnimal() {
		// TODO Auto-generated method stub
		return new Dog();
	}

}
