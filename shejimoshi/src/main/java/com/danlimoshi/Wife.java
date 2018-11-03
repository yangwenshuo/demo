package com.danlimoshi;

//懒汉模式
public class Wife {
	private static Wife wife = null;
	static Object obj = new Object();
	
	//注意单例模式的构造需要私有
	private Wife(){
		
	}
	
	public static Wife getInstance(){
		
		if(wife == null){
			//一个同步代码块  if判空
			synchronized (obj) {
				if (wife == null) {
					wife = new Wife();
				}
			} 
		}
		return wife;
	}
}
