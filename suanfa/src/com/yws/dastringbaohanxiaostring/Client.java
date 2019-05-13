package com.yws.dastringbaohanxiaostring;

public class Client {

    public static void main(String[] args) {

        String s1 = "1abcsdsdd43434";
        String s2 = "abc";

        char[] s1arr = s1.toCharArray();
        char[] s2arr = s2.toCharArray();

        for(int i = 0;i<s1arr.length;i++){

            for(int j = 0;j<s2arr.length;j++) {
                if(s1arr[i] == s2arr[j]){
                    if(j==s2arr.length-1){
                        System.out.println("有一样的 i 是" + i);
                    }
                    i++;

                }else{
                    i = i-j;
                    break;
                }
            }


        }

    }
}
