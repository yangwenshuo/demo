package com.jianzaozhemoshi;

public class DellComputerBuilder extends Builder{

	@Override
	public void addCpu() {
		// TODO Auto-generated method stub
		this.product.cpart.add("װ����dell��CPU,");
	}

	@Override
	public void addDisk() {
		// TODO Auto-generated method stub
		this.product.cpart.add("װ����dellӲ��,");
	}

	@Override
	public void addMainBorad() {
		// TODO Auto-generated method stub
		this.product.cpart.add("װ����dell����,");
	}
	
	public Product getProduct(){
		
		return this.product;
	}

}
