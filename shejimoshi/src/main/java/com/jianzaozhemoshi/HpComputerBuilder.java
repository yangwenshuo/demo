package com.jianzaozhemoshi;

public class HpComputerBuilder extends Builder{

	@Override
	public void addCpu() {
		// TODO Auto-generated method stub
		this.product.cpart.add("装上了HP的CPU");
	}

	@Override
	public void addDisk() {
		// TODO Auto-generated method stub
		this.product.cpart.add("装上了HP的硬盘");
	}

	@Override
	public void addMainBorad() {
		// TODO Auto-generated method stub
		this.product.cpart.add("装上了HP的主板");
	}

	@Override
	public Product getProduct() {
		// TODO Auto-generated method stub
		return this.product;
	}

}
