package com.zhuangtaimoshi;

public class YuQingState implements State{

	@Override
	public void quWu() {
		// TODO Auto-generated method stub
		System.out.println("玉清境界,我可以驱物了");
	}

	@Override
	public void shenJianYuLeiZhenJue() {
		// TODO Auto-generated method stub
		System.out.println("玉清境界不能使用神剑御雷真决");
	}

	@Override
	public void zhuXianJianZhen() {
		// TODO Auto-generated method stub
		System.out.println("玉清境界想玩诛仙剑阵?别做梦了!");
		
	}

	@Override
	public void xiuLian(WanJianYi wjy) {
		// TODO Auto-generated method stub
		System.out.println("经过你十分的努力修炼,你进入到上清境界");
		wjy.setState(new ShangQingState());
	}
	
}
