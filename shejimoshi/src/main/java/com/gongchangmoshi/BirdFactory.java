package com.gongchangmoshi;

public class BirdFactory implements Factory{

	@Override
	public Animal getAnimal() {
		// TODO Auto-generated method stub
		
		return new Bird();
	}

}
