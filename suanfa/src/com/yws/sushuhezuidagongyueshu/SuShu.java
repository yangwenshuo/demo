package com.yws.sushuhezuidagongyueshu;

public class SuShu {
    public static void main(String[] args) {
        int n = 47;

        if (n <= 3) {

        }
        int sqrt = (int) Math.sqrt(n);
        for (int i = 2; i <= sqrt; i++) {
            if (n % i == 0) {
                System.out.println("����Ǻ���,Լ����" + i);
            }
        }

        //��������û�д�ӡ�Ļ���˵��������
    }
}
