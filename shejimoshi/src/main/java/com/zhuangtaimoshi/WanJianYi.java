package com.zhuangtaimoshi;

public class WanJianYi {
	private State state = null;

	
	public void testQuWu(){
		this.state.quWu();
	}
	public void testShenJianYuLeiZhenJue(){
		this.state.shenJianYuLeiZhenJue();
	}
	public void testZhuXianJianZhen(){
		this.state.zhuXianJianZhen();
	}
	public void testXiuLan(){
		this.state.xiuLian(this);
	}
	
	public WanJianYi() {
		super();
	}
	
	public State getState() {
		return state;
	}
	
	public void setState(State state) {
		this.state = state;
	}
}
