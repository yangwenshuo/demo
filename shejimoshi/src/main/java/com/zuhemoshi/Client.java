package com.zuhemoshi;

public class Client {
	public static void main(String[] args) {
		//组合模式:组合多个对象形成树形结构以表示具有"整体-部分"关系的层次结构.组合模式对单个对象(子叶对象)和组合对象(容器对象)的使用具有一致
		//性,组合模式有可以称为"整体-部分"模式,他是一种对象结构型模式.
		
		//使用场景:在具有整体和部分的层次结构中，希望通过一种方式忽略整体与部分的差异，客户端可以一致地对待它们
		//在一个使用面向对象语言开发的系统中需要处理一个树形结构
		//在一个系统中能够分离出叶子对象和容器对象，而且它们的类型不固定，需要增加一些新的类型
		
		//编写方法:这里就是把叶节点类 和容器类全继承一个类,这样我们就可以用多态了,由于他们是继承自同一个Node类,那么就可以同一看待,统一操作了
		//但是容器是可以装东西的,就可以给容器增加减少东西,我们再容器类增加一个特有的成员变量,一个list,用于存储东西,这个list的泛型是
		//Node,这样无论是叶节点还是容器都可以放到这个list里,如果你扩展叶节点的类型,也不用改,因为只要你是继承了node类,那么就可以直接放到list
		//里,还有我们要提供增加,减少list里面的元素的方法,还有节点,容器的操作方法,我们把这些方法全都定义到node类里,这样节点类和容器类就都有
		//了名字一样的工作方法,但是这样节点类也有了操作list的方法,但是他们内部是没有list的,我们这样做,当他们调用这些操作list的方法时,就提示错误
		
		
		//即使以后你文件多了一个视频文件,也不需要改什么,只要你的视频类继承了LinuxFile类,那么我们folder类就可以存储,因为我们泛型是LinuxFile
		//而且你各种文件夹都可以存到我的list里面.
		
		Folder folderbig = new Folder("杨过的资料");
		
		Folder textfolder = new Folder("文本文档");
		Folder imgfolder = new Folder("图片文档");
		
		TextFile tf1 = new TextFile("诛仙.txt");
		TextFile tf2 = new TextFile("神墓.txt");
		
		ImageFile if1 = new ImageFile("清明上河图.jpg");
		ImageFile if2 = new ImageFile("蒙娜丽莎.jpg");
		ImageFile if3 = new ImageFile("奔马图.jpg");
		
		textfolder.addFile(tf1);
		textfolder.addFile(tf2);
		
		imgfolder.addFile(if1);
		imgfolder.addFile(if2);
		imgfolder.addFile(if3);
		
		folderbig.addFile(textfolder);
		folderbig.addFile(imgfolder);
		
	
		
		
		folderbig.killVirulFile();
		
	}
}
