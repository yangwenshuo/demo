package com.zhizelianmoshi;

public class PartMaster extends Master{
	@Override
	public void handleReq(int req) {
		// TODO Auto-generated method stub
		if(req<20){
			System.out.println("请假天数小于 20天，部门长来处理，批准了！");
		}else if(nextmaster!=null){
			nextmaster.handleReq(req);
		}
	}
}
