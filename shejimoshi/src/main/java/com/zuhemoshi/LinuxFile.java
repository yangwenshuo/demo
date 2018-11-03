package com.zuhemoshi;

public abstract class LinuxFile {
	private String name;

	public LinuxFile(String name) {
		super();
		this.name = name;
	}
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public abstract void addFile(LinuxFile f);
	public abstract void removeFile(LinuxFile f);
	public abstract LinuxFile getFile(int i);
	public abstract void killVirulFile();
}
