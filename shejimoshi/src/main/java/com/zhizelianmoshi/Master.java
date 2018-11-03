package com.zhizelianmoshi;

public abstract class Master {
	protected Master nextmaster;
	public abstract void handleReq(int req);
	public Master getNextmaster() {
		return nextmaster;
	}
	public void setNextmaster(Master nextmaster) {
		this.nextmaster = nextmaster;
	}
	
}
