package com.dongtaidailimoshi;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class BeanFactory {
	public static Object getBean(String interfacename){
		String classname = null;
		
		//��������Ľӿڵ�����,��������������Ľӿ�����ȥ�����ļ�����,Ȼ��õ�
		//Ŀǰ����Ҫ��������ӿڵ��ĸ�ʵ����.
		if("InMinion".equals(interfacename)){
			classname = "com.yws.store.dailitest.Minion";
		}
		try {
			//forname�õ�����Class����,Ҫ��õ������Ķ���Ҫ��newInstance����
			final Object obj = Class.forName(classname).newInstance();
			
			Object proxyinstance = Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), new InvocationHandler() {
				
				@Override
				public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
					// TODO Auto-generated method stub
					
					if(method.getName().equals("writeHomeWork")){
						System.out.println("����writeHomeWorkǰ��������ǿ");
						Object returnvalue = null;
						try {
							System.out.println("��������û���쳣");
							returnvalue = method.invoke(obj, args);
						} catch (Exception e) {
							// TODO: handle exception
							System.out.println("���� ,��������ǿ�Ķ������쳣����ץס");
						}
		
						System.out.println("����writeHomeWork������������ǿ");
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
