package com.yws.lianbiaofanxu;

import com.yws.data.LinkNode;
import sun.awt.image.ImageWatched;

public class Test {


    //把链表的顺序给倒过来，这种保留上一个的迭代或者递归问题
    //困扰了我好久，我不知道如何保留上一个，其实你就把上一个弄成成员变量就
    //可以了啊，不用弄成参数里
    public static void main(String[] args) {

        LinkNode preNode = null;
        LinkNode node = null;
        LinkNode nextNode = null;

        LinkNode linkList = LinkNode.getLinkList();
        node = linkList;

        //注意多用break的跳出功能

        while(node!=null){

            nextNode = node.next;

            node.next = preNode;


            preNode = node;


            //注意这里要用break的跳出功能
            if(nextNode == null){
                break;
            }
            node = nextNode;



        }


        LinkNode.show(node);




    }
}
