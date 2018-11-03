package com.dongtaidailimoshi;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class BeanFactory {
	public static Object getBean(String interfacename){
		String classname = null;
		
		//根据输入的接口的名字,正常是拿着输入的接口名称去配置文件里面,然后得到
		//目前我们要创建这个接口的哪个实现类.
		if("InMinion".equals(interfacename)){
			classname = "com.yws.store.dailitest.Minion";
		}
		try {
			//forname得到的是Class对象,要想得到真正的对象要用newInstance方法
			final Object obj = Class.forName(classname).newInstance();
			
			Object proxyinstance = Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), new InvocationHandler() {
				
				@Override
				public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
					// TODO Auto-generated method stub
					
					if(method.getName().equals("writeHomeWork")){
						System.out.println("我在writeHomeWork前面做了增强");
						Object returnvalue = null;
						try {
							System.out.println("看看你有没有异常");
							returnvalue = method.invoke(obj, args);
						} catch (Exception e) {
							// TODO: handle exception
							System.out.println("哈哈 ,我连被增强的东西的异常都能抓住");
						}
		
						System.out.println("我在writeHomeWork后面面做了增强");
						return returnvalue;
					}else{
						return method.invoke(obj, args);
					}
				}
			});
			return proxyinstance;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
		
	}
}
