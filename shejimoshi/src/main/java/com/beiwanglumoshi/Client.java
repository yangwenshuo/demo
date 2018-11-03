package com.beiwanglumoshi;

public class Client {
	public static void main(String[] args) {
		
		//刚刚恢复和
		// 备忘录模式主要有三个部分:被备份的东西(Role),备份的数据(Memento),保存备份数据的地方(你得搞个地方保存备份数据啊)
		//我们为啥要搞个备忘录模式呢,我创建一个新的BKRole,我把Role的内容挨个复制到BKRole里面把这个对象当作备忘录,然后
		//当需要还原数据的时候我把这个BKRole的对象挨个在复制会Role里不就行了吗.
		//这样的做法有两个很大的缺陷,这样的我们就把这个对象的细节暴露给用户的了,其次我们还要记住到底我们备份了什么属性(有时候
		//我们不一定非要备份所有的属性),然后才能还原,而且我们需要修改备份的属性的时候,我们要在保存的时候要改,在还原的时候也要改
		//这样就不太好了.
		
		//还有一个方法就是克隆,克隆好像不用写那么多代码,但是克隆有个比较大的缺点,用克隆的话就把所有的属性都备份了,我们并不是每次
		//都要备份那么多的
		
		//下面的例子就是备忘录，一个游戏角色去打boss之前都会保存他的血蓝武器这三个属性，然后再还原。
		
		//用备忘录模式的好处就是，你不用必须全部备份，对外看不到备份的细节，当你要修改像备份的属性的时候，只需要改被备份类
		//和bkrole就可以了，注意备份和还原方法都是写在Role里的。
		
		//备忘录模式:在不破坏封装性的前提下,捕获一个对象的内部状态,并在该对象之外保存这个状态,这样以后就可将该对象
		//恢复到之前的状态,备忘录的代码比较简单,关键是要理解为什么要使用备忘录模式.
		
		Role role = new Role("杨过", 18, "玄铁重剑", 90, 100);
		RoleBk bkRole = role.bkRole();
		BKManager bkmanager = new BKManager();
		bkmanager.setRolebk(bkRole);
		
		//看看打boss之前是什么样子
		role.show(); 
		
		
		role.fightBoss();
		//打完boss后看看变成什么样子了
		role.show();
		System.out.println("------------");
		
		role.recoverRole(bkmanager.getRolebk());
		//看看recover后是什么样子
		role.show();
		
		
	}
}
