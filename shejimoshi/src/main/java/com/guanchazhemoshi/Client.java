package com.guanchazhemoshi;

public class Client {
	public static void main(String[] args) {
		//�����߿�����ô˵,Ա����������Ϸ,�ϰ������,���鷢���˾�֪ͨ��Ա����,
		//����������,�����и���Ա����,��һ������,�����е�Ա���ĵ�ַ��������,���ϰ������,����������Ķ�������,
		//֪ͨ����������������Ա������,����Ա���ϰ������.
		//�������������javaweb�е��������,setAttribute������������������е���֪ͨһ��.                                                                                
		Emplyee e1 = new Emplyee("���");
		Emplyee e2 = new Emplyee("����");
		Emplyee e3 = new Emplyee("���޼�");
		Emplyee e4 = new Emplyee("��ëʨ��");
		
		MiShu ms = new MiShu();
		
		ms.addEmplyee(e1);
		ms.addEmplyee(e2);
		ms.addEmplyee(e3);
		ms.addEmplyee(e4);
		
		ms.tongZhiEmplyeeBossLaiLe();
	}
}
