package com.zuhemoshi;

public class Client {
	public static void main(String[] args) {
		//���ģʽ:��϶�������γ����νṹ�Ա�ʾ����"����-����"��ϵ�Ĳ�νṹ.���ģʽ�Ե�������(��Ҷ����)����϶���(��������)��ʹ�þ���һ��
		//��,���ģʽ�п��Գ�Ϊ"����-����"ģʽ,����һ�ֶ���ṹ��ģʽ.
		
		//ʹ�ó���:�ھ�������Ͳ��ֵĲ�νṹ�У�ϣ��ͨ��һ�ַ�ʽ���������벿�ֵĲ��죬�ͻ��˿���һ�µضԴ�����
		//��һ��ʹ������������Կ�����ϵͳ����Ҫ����һ�����νṹ
		//��һ��ϵͳ���ܹ������Ҷ�Ӷ�����������󣬶������ǵ����Ͳ��̶�����Ҫ����һЩ�µ�����
		
		//��д����:������ǰ�Ҷ�ڵ��� ��������ȫ�̳�һ����,�������ǾͿ����ö�̬��,���������Ǽ̳���ͬһ��Node��,��ô�Ϳ���ͬһ����,ͳһ������
		//���������ǿ���װ������,�Ϳ��Ը��������Ӽ��ٶ���,����������������һ�����еĳ�Ա����,һ��list,���ڴ洢����,���list�ķ�����
		//Node,����������Ҷ�ڵ㻹�����������Էŵ����list��,�������չҶ�ڵ������,Ҳ���ø�,��ΪֻҪ���Ǽ̳���node��,��ô�Ϳ���ֱ�ӷŵ�list
		//��,��������Ҫ�ṩ����,����list�����Ԫ�صķ���,���нڵ�,�����Ĳ�������,���ǰ���Щ����ȫ�����嵽node����,�����ڵ����������Ͷ���
		//������һ���Ĺ�������,���������ڵ���Ҳ���˲���list�ķ���,���������ڲ���û��list��,����������,�����ǵ�����Щ����list�ķ���ʱ,����ʾ����
		
		
		//��ʹ�Ժ����ļ�����һ����Ƶ�ļ�,Ҳ����Ҫ��ʲô,ֻҪ�����Ƶ��̳���LinuxFile��,��ô����folder��Ϳ��Դ洢,��Ϊ���Ƿ�����LinuxFile
		//����������ļ��ж����Դ浽�ҵ�list����.
		
		Folder folderbig = new Folder("���������");
		
		Folder textfolder = new Folder("�ı��ĵ�");
		Folder imgfolder = new Folder("ͼƬ�ĵ�");
		
		TextFile tf1 = new TextFile("����.txt");
		TextFile tf2 = new TextFile("��Ĺ.txt");
		
		ImageFile if1 = new ImageFile("�����Ϻ�ͼ.jpg");
		ImageFile if2 = new ImageFile("������ɯ.jpg");
		ImageFile if3 = new ImageFile("����ͼ.jpg");
		
		textfolder.addFile(tf1);
		textfolder.addFile(tf2);
		
		imgfolder.addFile(if1);
		imgfolder.addFile(if2);
		imgfolder.addFile(if3);
		
		folderbig.addFile(textfolder);
		folderbig.addFile(imgfolder);
		
	
		
		
		folderbig.killVirulFile();
		
	}
}
