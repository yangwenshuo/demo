package com.zhizelianmoshi;

public class PartMaster extends Master{
	@Override
	public void handleReq(int req) {
		// TODO Auto-generated method stub
		if(req<20){
			System.out.println("�������С�� 20�죬���ų���������׼�ˣ�");
		}else if(nextmaster!=null){
			nextmaster.handleReq(req);
		}
	}
}
