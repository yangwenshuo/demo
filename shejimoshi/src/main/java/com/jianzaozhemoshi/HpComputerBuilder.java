package com.jianzaozhemoshi;

public class HpComputerBuilder extends Builder{

	@Override
	public void addCpu() {
		// TODO Auto-generated method stub
		this.product.cpart.add("װ����HP��CPU");
	}

	@Override
	public void addDisk() {
		// TODO Auto-generated method stub
		this.product.cpart.add("װ����HP��Ӳ��");
	}

	@Override
	public void addMainBorad() {
		// TODO Auto-generated method stub
		this.product.cpart.add("װ����HP������");
	}

	@Override
	public Product getProduct() {
		// TODO Auto-generated method stub
		return this.product;
	}

}
