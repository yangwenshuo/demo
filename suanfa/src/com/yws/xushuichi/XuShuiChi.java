package com.yws.xushuichi;

public class XuShuiChi {

    public static void main(String[] args) {
        int[] intarr = {5,2,1,6,3,4,2};
        int value = 0;

        for(int i=0;i<intarr.length;i++){
            int lefthigh = -1;
            int righthigh = -1;
            int temp1 = intarr[i];
            for(int j = 0; j<i;j++){

                if(intarr[j]>temp1){
                    temp1 = intarr[j];
                    lefthigh = j;
                }
            }

            int temp2 = intarr[i];
            for(int j = i+1; j<intarr.length;j++){
                if(intarr[j]>temp2){
                    temp2 = intarr[j];



                    //test


                    righthigh = j;
                }
            }



            if(lefthigh == -1 && righthigh == -1){

            }else if(lefthigh == -1 && righthigh != -1){
//                value += intarr[righthigh]-intarr[i];
//                System.out.println(i + "加了" + (intarr[righthigh]-intarr[i]));
            }else if(lefthigh != -1 && righthigh == -1){
//                value += intarr[lefthigh]-intarr[i];
//                System.out.println(i + "加了" + (intarr[lefthigh]-intarr[i]));
            }else{
                value += (intarr[lefthigh]>intarr[righthigh]?intarr[righthigh]:intarr[lefthigh])-intarr[i];
                System.out.println(i + "加了" + ((intarr[lefthigh]>intarr[righthigh]?intarr[righthigh]:intarr[lefthigh])-intarr[i]));
            }


        }

        System.out.println(value);
    }
}
