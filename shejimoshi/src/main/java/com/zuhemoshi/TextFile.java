package com.zuhemoshi;

public class TextFile extends LinuxFile{

	
	public TextFile(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addFile(LinuxFile c) {
		// TODO Auto-generated method stub
		System.out.println("��Ϊһ���ı��ļ�,�㲻�����Լ���������ļ�");
	}

	@Override
	public void removeFile(LinuxFile c) {
		// TODO Auto-generated method stub
		System.out.println("��Ϊһ���ı��ļ�,�㲻�ܴ��Լ�����ɾ���ļ�");
		
	}

	@Override
	public LinuxFile getFile(int i) {
		// TODO Auto-generated method stub
		System.out.println("��Ϊһ���ı��ļ�,���ܴ��Լ������ȡ�ļ�");
		return null;
	}

	@Override
	public void killVirulFile() {
		// TODO Auto-generated method stub
		System.out.println("�ı��ļ�" + this.getName() + "������ɱ��");
	}
	

}
