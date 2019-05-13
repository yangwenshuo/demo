package com.yws.dastringbaohanxiaostring;

public class Client2 {
    public static void main(String[] args) {

        String s1 = "1222adcsdsdd43434";
        String s2 = "abc";

        char[] s1arr = s1.toCharArray();
        char[] s2arr = s2.toCharArray();


        int i = 0;
        int j = 0;
        while(i<s1arr.length && j<s2arr.length){

            if(s1arr[i] == s2arr[j]){
                if(j==s2arr.length-1){
                    System.out.println("包i回家 i是" + i);
                }
                i++;
                j++;
            }else{
                j=0;
                i=i-j+1;
            }

        }


    }
}
