package com.zhuangtaimoshi;

public class YuQingState implements State{

	@Override
	public void quWu() {
		// TODO Auto-generated method stub
		System.out.println("���徳��,�ҿ���������");
	}

	@Override
	public void shenJianYuLeiZhenJue() {
		// TODO Auto-generated method stub
		System.out.println("���徳�粻��ʹ�����������");
	}

	@Override
	public void zhuXianJianZhen() {
		// TODO Auto-generated method stub
		System.out.println("���徳���������ɽ���?��������!");
		
	}

	@Override
	public void xiuLian(WanJianYi wjy) {
		// TODO Auto-generated method stub
		System.out.println("������ʮ�ֵ�Ŭ������,����뵽���徳��");
		wjy.setState(new ShangQingState());
	}
	
}
