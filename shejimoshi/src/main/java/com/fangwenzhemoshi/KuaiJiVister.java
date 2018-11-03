package com.fangwenzhemoshi;

public class KuaiJiVister implements Vister{

	@Override
	public void vister(OutAccount a) {
		// TODO Auto-generated method stub
		System.out.println("会计查看了支出的账单,减去"+a.getMoney()+"元!");
	}

	@Override
	public void vister(InAccount a) {
		// TODO Auto-generated method stub
		System.out.println("会计查看了收入的账单,增加"+a.getMoney()+"元 !");
	}

}
