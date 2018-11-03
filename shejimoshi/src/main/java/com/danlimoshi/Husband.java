package com.danlimoshi;

//¶öººÄ£Ê½

public class Husband {
	private static Husband instance = new Husband();
	
	private Husband(){
		
	}
	
	public static Husband getInstance(){
		return instance;
	}
}
