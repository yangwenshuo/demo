package com.jiandangongchangmoshi;

public class AnimalFactory {
	
	public static Animal getAnimal(String animalname){
		
		Animal a = null;
		
		switch (animalname) {
		
			case "pig":
				a = new Pig();

				break;
			case "cat":
				a = new Cat();
				break;
			case "tiger":
				a = new Tiger();
				break;
	
			default:
			{
				System.out.println("ÄãÊäÈëµÄ×Ö·û´®ÓĞÎó");
				break;
			}
		}
		
		return a;
	}
}
