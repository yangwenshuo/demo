package com.zuhemoshi;

public class ImageFile extends LinuxFile{

	

	public ImageFile(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addFile(LinuxFile c) {
		// TODO Auto-generated method stub
		System.out.println("身为一个图片文件,你不能往自己里面添加文件");
	}

	@Override
	public void removeFile(LinuxFile c) {
		// TODO Auto-generated method stub
		System.out.println("身为一个图片文件,你不能从自己里面删除文件");
		
	}

	@Override
	public LinuxFile getFile(int i) {
		// TODO Auto-generated method stub
		System.out.println("身为一个图片文件,不能从自己里面获取文件");
		return null;
	}

	@Override
	public void killVirulFile() {
		// TODO Auto-generated method stub
		System.out.println("图片文件"+this.getName() + "进行了杀毒");
	}
	

}
