package com.diedaiqimoshi;

public class Client {
	//迭代器模式:提供一种方法顺序访问一个聚合对象中各个元素,而又不暴露该对象的内部表示.
	//这个模式就是为了变量集合和数组的,现在各大语言已经自动实现迭代器模式了,比如我们的foreach就是迭代器实现的.
	//我们就可以直接用实现的迭代器遍历数组集合就可以了,所以这个设计模式的实用意义已经不大了,主要是学习的意义了.
	
	//迭代器模式的好处据说是遍历的时候不暴露细节,这个主要指的是,我们在遍历的时候,先获得了一个迭代器对象,我们在遍历的时候操作的一直是这个迭代器对象
	
	//迭代器模式和状态模式都用到了这个,一个类A,类A中有一个成员变量是一个对象B,这个对象B中的xxb方法的参数是类A,或者这个对象B用到了类A,
	//类A中提供了一个xxa方法用来调用自己内部的对象B的xxb方法,并且把自己当作参数传了进去,cb.xxb(this);执行这个xxb的时候就可以改变A
	//具体就像:
	//	public class ClassA{
	//		public ClassB cb ;
	//		public void xxa(){
	//			cb.xxb(this);
	//		}
	//	}
	
	
	//不不,这个和状态模式的那么不一样,这个是构造方法有关联,对象B的构造方法的参数是类A的对象.
	
	//遍历的时候我们就操作了iterator对象,没有操作集合对象,而且用知道长度. 
	
	//下面我们用数组实现这个迭代器,用集合也可以,集合方便一点.
	
	
	
	//hasnext的判断依据是根据object[]数组的传进来的长度和遍历index比较的来的,所以遍历的时候不能做增加或减少元素.
	//next方法利用的是get(index)方法
	
	//这个设计模式可以看一看
	
	//这样我们就用数组模拟出了一个类似于集合迭代器的东西.
	
	public static void main(String[] args) {
		AList alist = new AList();
		alist.add("秦舞阳");
		alist.add("九天");
		alist.add("独孤败天");
		alist.add("魔主");
		alist.add("七绝天女");
		
		Iterator iterator = alist.getIterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		
		
	}
}
