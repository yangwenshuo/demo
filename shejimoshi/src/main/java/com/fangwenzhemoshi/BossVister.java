package com.fangwenzhemoshi;

public class BossVister implements Vister{

	@Override
	public void vister(OutAccount a) {
		// TODO Auto-generated method stub
		
		System.out.println("老板查看了支出的账单,花了"+a.getMoney()+"生气!");
	}

	@Override
	public void vister(InAccount a) {
		// TODO Auto-generated method stub
		System.out.println("老板查看的收入的账单,收入"+a.getMoney()+"开心!");
	}

}
