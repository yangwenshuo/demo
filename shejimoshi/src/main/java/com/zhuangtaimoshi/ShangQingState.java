package com.zhuangtaimoshi;

public class ShangQingState implements State{

	@Override
	public void quWu() {
		// TODO Auto-generated method stub
		System.out.println("上清境界,驱物可谓得心应手");
	}

	@Override
	public void shenJianYuLeiZhenJue() {
		// TODO Auto-generated method stub
		System.out.println("上清境界,可以使用威力强大的神剑御雷真决");
	}

	@Override
	public void zhuXianJianZhen() {
		// TODO Auto-generated method stub
		System.out.println("上清境界还不能使用诛仙剑阵,需要多加修炼");
	}

	@Override
	public void xiuLian(WanJianYi wjy) {
		// TODO Auto-generated method stub
		System.out.println("经过多年的努力 ,终于进入了太清境界");
		wjy.setState(new TaiQingState());
	}

}
