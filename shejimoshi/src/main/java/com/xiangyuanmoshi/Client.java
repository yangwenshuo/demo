package com.xiangyuanmoshi;

public class Client {
	
	
		//记住享元模式是一个比较大的单例模式.
	
	
		//享元模式:运用共享技术有效的支持大量细粒度的对象
		//共享可以共享的对象,避免大量的创建对象占用空间
	public static void main(String[] args) {
		//java种的字符串用的就是享元模式,字符串常量是复用的,相同的字符串地址是一样的的
		//比如String s = "杨过"; String 1 = "杨过";,其实这两个地址是一样的,因为是共享的.
		WebSiteFactory wsf = new WebSiteFactory();
		//在享元模式中有的部分是可以共享复用的,有的部分是根据场景不同是有区别,也就不能共享了
		//可以共享的部分叫内部东西,有自己特点不同的部分叫外部东西.
		//在本例中网站就是内部部分,用户就是外部东西.网站是一对多的,一个网站可以服务多个人,不是一个人对应阿里1,另一个阿里2
		//共享部分用工厂维护,里面用hashmap保存,因为这些共享部分是复用的,所以就有一个,这个工厂就维护共享对象的单例性
		
		
		
		//享元模式,咋说呢,好像是单例模式的扩展,比如网站,阿里巴巴只有一个,百度也只有一个,腾讯网也只有一个.
		//这三个是不能创建多个对象的,或者说这些个网站都是单例的,你可以对他们挨个使用单例模式.
		
		
		//也可以搞这种享元模式,搞一个工厂类,这个工厂类的内部有一个map,这几个网站名字用他们的名字的字符串和他们的网站实例对象
		//保存到这个map里,这个工厂类提供用key(名字的字符串网站名字)获取到对象的value(也就是他们的网址实例对象),当一个类需要用
		//网站对象的时候,直接用输入对应的网址的名字从工厂类,用value = get(key)方法来获取对象,这样获取的就是单例的.
		
		//这样从工厂类获取的网站就是单例的,注意这个工厂类内部的map要是静态的.
		
		
		
		WebSite a1 = wsf.getWebSite("阿里巴巴");
		User u1 = new User("杨过");
		a1.use(u1);
		
		WebSite a2 = wsf.getWebSite("阿里巴巴");
		User u2 = new User("赵敏");
		a2.use(u2);
		
		WebSite a3 = wsf.getWebSite("阿里巴巴");
		User u3 = new User("谢逊");
		a3.use(u3);
		
		WebSite r1 = wsf.getWebSite("人人网");
		User u4 = new User("殷天正");
		r1.use(u4);
		
		WebSite r2 = wsf.getWebSite("人人网");
		User u5 = new User("黛绮丝");
		r2.use(u5);
		
		WebSite r3 = wsf.getWebSite("人人网");
		User u6 = new User("韦一笑");
		r3.use(u6);
		
		System.out.println(wsf.getWebSiteNum());
	}
}
