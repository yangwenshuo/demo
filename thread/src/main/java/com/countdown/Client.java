package com.countdown;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {

	//countdownlatch��������,һ���̵߳�N���߳�(���N����countdownlatch�������ò���
	// ��ʱ��ָ����)
	//countdownlatch�Ǳ������cdl.await()����ʹ�õ�
	//�����������˼���ǿ����������õ�N�������߳̿���û��



	//���û�п���ͻ�����������,�ȴ�����,!!!!!!!!!!!!!!!!


	//�ȴ���������������,������ټ����� �����countdownlathc������
    //���Ǹ��������ź����Ķ�����semaphore

	public static void main(String[] args) throws InterruptedException {
		CountDownTestData cdate = new CountDownTestData();
		CountDownRunable cr = new CountDownRunable(cdate);
		CountDownRunable2 cr2 = new CountDownRunable2(cdate);
		//�����Ļ���������ͬ��runable�еĳ�Ա��������һ������,���������ֲ�ͬ���߳�
		//�乲���˱���
		CountDownLatch cdl = cdate.getCdl();
		
		ExecutorService threadPool = Executors.newFixedThreadPool(5);
		
		for (int i = 0; i < 2; i++) {
			threadPool.submit(cr);
		}
		for (int i = 0; i < 3; i++) {
			threadPool.submit(cr2);
		}


		cdl.await();
		
		System.out.println("�������� ��������");
		
		
	}

}
