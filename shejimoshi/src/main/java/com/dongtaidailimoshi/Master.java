package com.dongtaidailimoshi;

import org.junit.Test;

public class Master {
	//这里是可以强转的,多态的
	private InMinion min = (InMinion) BeanFactory.getBean("InMinion");
	
	@Test
	public void test(){
		try {
			//单wiretehomework的异常是可以在工厂里被抓住的,所以我们可以
			//用IOP思想也就是动态代理的方法,对一个方法的前面增强,后面增强,也可以
			//抓住这个方法的异常.
			min.writeHomeWork();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
