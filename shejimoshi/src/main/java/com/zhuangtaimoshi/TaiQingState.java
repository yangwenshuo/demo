package com.zhuangtaimoshi;

public class TaiQingState implements State{

	@Override
	public void quWu() {
		// TODO Auto-generated method stub
		System.out.println("̫�徳��,���ǰ�һ��ɽ������");
	}

	@Override
	public void shenJianYuLeiZhenJue() {
		// TODO Auto-generated method stub
		System.out.println("̫�徳��������������������");
	}

	@Override
	public void zhuXianJianZhen() {
		// TODO Auto-generated method stub
		System.out.println("̫�徳�����ʹ��ǿ������ɽ�����!");
	}

	@Override
	public void xiuLian(WanJianYi wjy) {
		// TODO Auto-generated method stub
		System.out.println("���Ѿ������������淨�Ķ�����,��ʵ���Ű�");
	}

}
