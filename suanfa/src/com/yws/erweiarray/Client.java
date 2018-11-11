package com.yws.erweiarray;

import java.util.ArrayList;

public class Client {
    public static void main(String[] args) {

        char[][] chs = {{'a','b','c','d','e'},{'f','g','h','i','j'},{'k','l','m','n','o'},
                {'p','q','r','s','t'},{'u','v','w','x','y'}};

        ArrayList<String> arrayList = new ArrayList<>();

        for (int i = 0;i<chs.length;i++){
            String s = new String(chs[i]);
            arrayList.add(s);
        }

        for(int j =0 ;j<chs.length;j++){

            char[] chars = new char[chs.length];

            //注意这些东西都是要写在外面的


            for (int i = 0; i<chs.length;i++){

                //这里面只给数组赋值
                chars[i] = chs[i][j];


            }

            //每一轮都对应一个字符串.
            String s = new String(chars);
            arrayList.add(s);
        }

        String c = "lgbb";
        StringBuilder sb = new StringBuilder(c);
        sb.reverse();
        String c1 = sb.toString();

        for (String s:arrayList){
            if (s.contains(c) || s.contains(c1)){
                System.out.println("找到了");
            }
        }


    }
}
