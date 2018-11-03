package com.zhizelianmoshi;

public class GroupMaster extends Master{

	@Override
	public void handleReq(int req) {
		// TODO Auto-generated method stub
		if(req<10){
			System.out.println("请假天数小于 10天，组长来处理，批准了！");
		}else if(nextmaster!=null){
			nextmaster.handleReq(req);
		}
	}

}
