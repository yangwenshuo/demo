package com.yws.luanxujiheshuffer;

import java.util.Collections;
import java.util.ListIterator;
import java.util.Random;
import java.util.RandomAccess;

public class Test {

    public static void main(String[] args) {

        //java自带的乱序功能，就是从最后一个起，用nextint获取前面的随机的
        //索引，交换位置，而nextint是有一个公式的
//        public static void shuffle(List<?> list, Random rnd) {
//            int size = list.size();
//            if (size < SHUFFLE_THRESHOLD || list instanceof RandomAccess) {
//                for (int i=size; i>1; i--)
                  //  swap(list, i-1, rnd.nextInt(i));
//            } else {
//                Object arr[] = list.toArray();
//
//                // Shuffle array
//                for (int i=size; i>1; i--)
//                    swap(arr, i-1, rnd.nextInt(i));
//
//                // Dump array back into list
//                // instead of using a raw type here, it's possible to capture
//                // the wildcard but it will require a call to a supplementary
//                // private method
//                ListIterator it = list.listIterator();
//                for (int i=0; i<arr.length; i++) {
//                    it.next();
//                    it.set(arr[i]);
//                }
//            }
//        }


    }
}
