package com.zhizelianmoshi;

public class BossMaster extends Master{

	@Override
	public void handleReq(int req) {
		// TODO Auto-generated method stub
		if(req>30){
			System.out.println("���30������������������ǿ�����");
		}
	}

}
