package com.dongtaidailimoshi;

public class Minion implements InMinion{

	@Override
	public void writeHomeWork() throws ClassNotFoundException {
		// TODO Auto-generated method stub
		Class forName = Class.forName("com.yws.store.dailitest.Master.qq");
		System.out.println("作业做完了");
	}

}
