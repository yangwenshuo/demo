package com.yws.sushuhezuidagongyueshu;

public class ZuiDaGongYueShu {

    public static void main(String[] args) {

        // a*b = 他俩的最大公约数*他俩的最小公倍数


        int i =  750;
        int j = 500;

        int yueshu = i%j;

        while(yueshu!=0){

            i=j;
            j=yueshu;
            yueshu = i%j;
        }

        //注意这里的打印的时候打印的是j而不是yushu
        System.out.println("最大公约数是" + j);

    }
}
