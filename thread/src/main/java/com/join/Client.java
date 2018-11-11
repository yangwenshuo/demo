package com.join;

public class Client {
	public static void main(String[] args) {
		
		
		
		final Thread t1 = new Thread(new RunableTest());
		t1.start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					
					
					
					
					
					//我在另一个线程里对t1进行join操作。
					t1.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("你终于他妈的忙完了！！！！");
			}
		}).start();
	}
}
