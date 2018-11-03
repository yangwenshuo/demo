package com.zuhemoshi;

import java.util.ArrayList;

public class Folder extends LinuxFile{

	private ArrayList<LinuxFile> al = new ArrayList<LinuxFile>();
	
	public Folder(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addFile(LinuxFile f) {
		// TODO Auto-generated method stub
		al.add(f);
	}

	@Override
	public void removeFile(LinuxFile f) {
		// TODO Auto-generated method stub
		al.remove(f);
	}

	@Override
	public LinuxFile getFile(int i) {
		// TODO Auto-generated method stub
		return al.get(i);
	}

	@Override
	public void killVirulFile() {
		// TODO Auto-generated method stub
		System.out.println(this.getName() + "开始消毒了");
		for (LinuxFile file : al) {
			file.killVirulFile();
		}
	}

}
