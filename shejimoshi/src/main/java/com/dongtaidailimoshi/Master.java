package com.dongtaidailimoshi;

import org.junit.Test;

public class Master {
	//�����ǿ���ǿת��,��̬��
	private InMinion min = (InMinion) BeanFactory.getBean("InMinion");
	
	@Test
	public void test(){
		try {
			//��wiretehomework���쳣�ǿ����ڹ����ﱻץס��,�������ǿ���
			//��IOP˼��Ҳ���Ƕ�̬����ķ���,��һ��������ǰ����ǿ,������ǿ,Ҳ����
			//ץס����������쳣.
			min.writeHomeWork();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
