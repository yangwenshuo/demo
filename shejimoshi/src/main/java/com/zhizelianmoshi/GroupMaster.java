package com.zhizelianmoshi;

public class GroupMaster extends Master{

	@Override
	public void handleReq(int req) {
		// TODO Auto-generated method stub
		if(req<10){
			System.out.println("�������С�� 10�죬�鳤��������׼�ˣ�");
		}else if(nextmaster!=null){
			nextmaster.handleReq(req);
		}
	}

}
