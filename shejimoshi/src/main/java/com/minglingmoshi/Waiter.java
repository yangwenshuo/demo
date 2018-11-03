package com.minglingmoshi;

import java.util.ArrayList;

public class Waiter {

	private ArrayList<CookCammond> al = new ArrayList<CookCammond>();
	
	public void setCammond(CookCammond cc){
		al.add(cc);
	}
	
	public void notifyCooker(){
		for (CookCammond cookCammond : al) {
			//注意这里,CookCammond类虽然是抽象类,但是传的时候是他的实现类对象,调用的是实现类重写后的
			//方法
			cookCammond.excute();
		}
	}
	
	
}
