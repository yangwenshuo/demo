package com.jianzaozhemoshi;

public abstract class Builder {
	public Product product = new Product();
	public abstract void addCpu();
	public abstract void addDisk();
	public abstract void addMainBorad();
	public abstract Product getProduct();
}
