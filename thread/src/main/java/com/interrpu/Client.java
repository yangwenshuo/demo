package com.interrpu;

public class Client {
	public static void main(String[] args) {

		//�������߳�������״̬,�������������̵߳�
		//interrupt()����,��ô����߳̾�����,���һ���һ���쳣,���
		//�쳣����catchס�˾ͻ���catch����Ĵ���,���û��catchס,
		//��ô�쳣�׵����������߳̾�ֹͣ��


		
		//ע���̵߳�ֹͣ��������������stop�ȽϺ�,�������Ҳ�Ƿ���ֹͣ��
		//��������ֹͦͣ,���ܻ��̸߳�һ�¾�ֹͣ,�����������ܵ�������,�ƻ���
		//�߼�,���ܻ��к����صĺ��,ֹͣ�߳���õķ�ʽ����һ���߳��ж�
		
		
		
		Thread t = new Thread(new Runnable(){

			@Override
			public void run() {
				
				
				//������,����ͨ����ѭ�������ӱ�־λ�ж�.
				//Ȼ����break��ȥ�Ϳ���.
				
				
				//���߻����Ը�һ������,����whileѭ���ı�־λ
				
				while(true) {
					System.out.println("��������ն");
					

					System.out.println("����������");
					
					
				
					//�㿴�Ұ��жϷ��������,�Ͳ����ƻ���һ�����߼�
					if(Thread.currentThread().isInterrupted()) {
						System.out.println("�����л���,������");
						break;
					}
				}
			}
			
		});
		
		
		t.start();
		
		try {
			Thread.currentThread().sleep(2000);
			
			
			
			//����interrupt���������ñ�־λ��
			t.interrupt();
			
			
			
			
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
