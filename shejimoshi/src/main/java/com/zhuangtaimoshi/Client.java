package com.zhuangtaimoshi;

	//state��ʵ������Ҫ������ְ��,1,����״̬�µ�����,2,�ӱ�״̬���ȵ�����״̬

	//�����õ��������ϵ,һ����ĳ�Ա������һ������,��������и������Ĳ����������Ķ���,������������ڲ����������Ա���������
	//������ʱ�����   ��Ա��������.method(this),��������͹�����,��������,��Ҳ������.
	//���ǳ�Ϊ˫�߹�ϵ.




public class Client {
	public static void main(String[] args) {
		//״̬ģʽ:��һ�����������״̬�ı�ʱ����ı�����Ϊ,�������������ı�����.
		//���״̬ģʽ��������,����������ڲ�ͬ��״̬ʱ,���ķ����ǲ�ͬ��.
		//��һ������״̬,����,����,̫��,������״̬��ת����,���Ե��÷�����ת״̬,�����Ļ��Ͳ���switch�жϵ��״���ʲô״̬
		//Ȼ������������.�����̫���������һ���������״̬�Ļ��ʹ��������,Ȼ�����̫����Ϳ�����,switch���ø�.
		//ͬʱ,��һ�ڲ�ͬ״̬��ʱ����÷����ǲ�ͬ��Ч��
		
		WanJianYi wjy = new WanJianYi();
		wjy.setState(new YuQingState());
		//��ʱ������״̬,���ǿ�����һ������ģʽ����Щʲô
		wjy.testQuWu();
		wjy.testShenJianYuLeiZhenJue();
		wjy.testZhuXianJianZhen();
		wjy.testXiuLan();
		//����һ����һ�޵�������״̬,���ǿ�������״̬,������Щʲô
		wjy.testQuWu();
		wjy.testShenJianYuLeiZhenJue();
		wjy.testZhuXianJianZhen();
		wjy.testXiuLan();
		//����һ����һ�޵���̫��״̬,���ǿ���̫��״̬,������Щʲô
		wjy.testQuWu();
		wjy.testShenJianYuLeiZhenJue();
		wjy.testZhuXianJianZhen();
		wjy.testXiuLan();
	}
}
