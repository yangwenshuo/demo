package com.interrpu;

public class Clientsleep {
	public static void main(String[] args) {
		
		//Ϊʲôsleep��ʱ�����һ��interrupt���쳣��
		//��Ϊinterrupt����˼��������ֹͣ����ô����������˯��
		//������ֹͣ���ҿ���˯�ܾ��Ѳ��������Ҿͻ���û��ֹͣ
		//��ô����������һ����Ϣ����Ȼ����˯��������ֱ�Ӹ��ҽ��Ѳ���
		//һ���쳣����catch�����������interrupt��־λ����������һ�£�
		//��Ϊ����˼ҽ��ѣ��˼Ұ���ı�־λ����ˣ�
		
		
		Thread t = new Thread(new Runnable(){

			@Override
			public void run() {
				
				while(true) {
					
					if(Thread.currentThread().isInterrupted()) {
						System.out.println("�����л���,������");
						break;
					}
					
					System.out.println("��������ն");
					
					try {
						Thread.currentThread().sleep(10000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						
						
						//Ҫ�ǲ��뿴����Щ�쳣��ӡ��Ϣ�Ͱ����и�ע����
						e.printStackTrace();
						
						
						System.out.println("�յ���������");
						
						//�������ô�ϱ�־λ��
						Thread.currentThread().interrupt();
					}
					
				}
			}
			
		});
		
		t.start();
		
		try {
			Thread.currentThread().sleep(2000);
			t.interrupt();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
