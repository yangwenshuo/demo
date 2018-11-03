package com.zuhemoshi;

public class TextFile extends LinuxFile{

	
	public TextFile(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addFile(LinuxFile c) {
		// TODO Auto-generated method stub
		System.out.println("身为一个文本文件,你不能往自己里面添加文件");
	}

	@Override
	public void removeFile(LinuxFile c) {
		// TODO Auto-generated method stub
		System.out.println("身为一个文本文件,你不能从自己里面删除文件");
		
	}

	@Override
	public LinuxFile getFile(int i) {
		// TODO Auto-generated method stub
		System.out.println("身为一个文本文件,不能从自己里面获取文件");
		return null;
	}

	@Override
	public void killVirulFile() {
		// TODO Auto-generated method stub
		System.out.println("文本文件" + this.getName() + "进行了杀毒");
	}
	

}
