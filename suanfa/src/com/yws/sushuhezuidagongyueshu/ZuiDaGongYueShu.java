package com.yws.sushuhezuidagongyueshu;

public class ZuiDaGongYueShu {

    public static void main(String[] args) {

        // a*b = ���������Լ��*��������С������


        int i =  750;
        int j = 500;

        int yueshu = i%j;

        while(yueshu!=0){

            i=j;
            j=yueshu;
            yueshu = i%j;
        }

        //ע������Ĵ�ӡ��ʱ���ӡ����j������yushu
        System.out.println("���Լ����" + j);

    }
}
