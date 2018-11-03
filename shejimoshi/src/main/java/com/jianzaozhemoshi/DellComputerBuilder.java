package com.jianzaozhemoshi;

public class DellComputerBuilder extends Builder{

	@Override
	public void addCpu() {
		// TODO Auto-generated method stub
		this.product.cpart.add("装上了dell的CPU,");
	}

	@Override
	public void addDisk() {
		// TODO Auto-generated method stub
		this.product.cpart.add("装上了dell硬盘,");
	}

	@Override
	public void addMainBorad() {
		// TODO Auto-generated method stub
		this.product.cpart.add("装上了dell主板,");
	}
	
	public Product getProduct(){
		
		return this.product;
	}

}
