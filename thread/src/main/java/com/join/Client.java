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
					
					
					
					
					
					//������һ���߳����t1����join������
					t1.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("�����������æ���ˣ�������");
			}
		}).start();
	}
}
