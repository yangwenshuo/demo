package com.zhuangtaimoshi;

public class ShangQingState implements State{

	@Override
	public void quWu() {
		// TODO Auto-generated method stub
		System.out.println("���徳��,�����ν����Ӧ��");
	}

	@Override
	public void shenJianYuLeiZhenJue() {
		// TODO Auto-generated method stub
		System.out.println("���徳��,����ʹ������ǿ������������");
	}

	@Override
	public void zhuXianJianZhen() {
		// TODO Auto-generated method stub
		System.out.println("���徳�绹����ʹ�����ɽ���,��Ҫ�������");
	}

	@Override
	public void xiuLian(WanJianYi wjy) {
		// TODO Auto-generated method stub
		System.out.println("���������Ŭ�� ,���ڽ�����̫�徳��");
		wjy.setState(new TaiQingState());
	}

}
