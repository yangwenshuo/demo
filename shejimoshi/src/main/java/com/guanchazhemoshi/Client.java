package com.guanchazhemoshi;

public class Client {
	public static void main(String[] args) {
		//监视者可以这么说,员工们在玩游戏,老板回来了,秘书发现了就通知给员工们,
		//可以这样做,秘书有个成员变量,是一个集合,把所有的员工的地址放在里面,等老板回来了,秘书调用他的东西方法,
		//通知方法里遍历他的这个员工集合,告诉员工老板回来了.
		//这个就宛如我们javaweb中的域监听器,setAttribute方法里遍历域里存的所有的域通知一下.                                                                                
		Emplyee e1 = new Emplyee("杨过");
		Emplyee e2 = new Emplyee("赵敏");
		Emplyee e3 = new Emplyee("张无忌");
		Emplyee e4 = new Emplyee("金毛狮王");
		
		MiShu ms = new MiShu();
		
		ms.addEmplyee(e1);
		ms.addEmplyee(e2);
		ms.addEmplyee(e3);
		ms.addEmplyee(e4);
		
		ms.tongZhiEmplyeeBossLaiLe();
	}
}
