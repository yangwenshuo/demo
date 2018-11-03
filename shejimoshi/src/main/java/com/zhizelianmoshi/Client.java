package com.zhizelianmoshi;

public class Client {
	//职责链模式：使多个对象都有机会处理请求，从而避免请求的发送者和接收者之间的耦合关系，将这个对象连成一条链
	//，并沿着这条链传递该请求，直到有一个对象处理他为止。
	public static void main(String[] args) {
		//反正就是处理对象挨个引用下一个,就跟链表的next一样
		
		//当用户提交一个请求时，请求是沿着一个链式结构传递，直到由一个对象负责处理这个请求。
		//使得接收者和发送者都没有对方的明确信息，且链中的对象自己也并不知道链式的结构，结果是职责链可以简化对象的相互链接。
		//降低了耦合，修改一个处理对象不会影响到其他的处理对象，也方便的了扩展，增加了指派职责的灵活性。
		//但是有可能到了链的最后请求还是没有被处理，需要规划好链的功能。
		
		//一个找领导请假的方法,当请假10天以下,会调到小组长处理,当请假15天以下,会调到部门长处理
		//当请假达到了30天,找老总处理.
		
		Master m = getHandler();
		
		
		//请假40天
		m.handleReq(40);
		//请假15天
		m.handleReq(15);
		//请假5天
		m.handleReq(5);
		
	}
	
	//把这里给封装的原因就是用户看不到我们的链式处理结构，对于用户来说我们只有一个处理对象
	private static Master getHandler() {
		// TODO Auto-generated method stub
		GroupMaster gm = new GroupMaster();
		PartMaster pm = new PartMaster();
		BossMaster bm = new BossMaster();
		//继承的好处，由于在父类写了get和set方法，我们这里就可以直接用
		gm.setNextmaster(pm);
		pm.setNextmaster(bm);
		return gm;
	}
	
	

}
