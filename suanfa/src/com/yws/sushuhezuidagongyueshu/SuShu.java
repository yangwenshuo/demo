package com.yws.sushuhezuidagongyueshu;

public class SuShu {
    public static void main(String[] args) {
        int n = 47;

        if (n <= 3) {

        }
        int sqrt = (int) Math.sqrt(n);
        for (int i = 2; i <= sqrt; i++) {
            if (n % i == 0) {
                System.out.println("这个是合数,约数是" + i);
            }
        }

        //如果到最后都没有打印的话就说明是质数
    }
}
