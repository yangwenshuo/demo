package com.join;

public class RunableTest implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 100; i++) {
			System.out.println("流影电光闪" + i);
		}
	}

}
