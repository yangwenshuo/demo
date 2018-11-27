package com.yws.panduanlianbiaoshifouyouhuan;

import com.yws.data.LinkNode;

public class Client {

    public static void main(String[] args) {
        //判断一个链表中是否有环

        //快慢指针的方法

        LinkNode slow = null;

        LinkNode fast = null;

        LinkNode linkNode = LinkNode.getLinkList();

        fast = linkNode.next.next;
        slow = linkNode.next;
        while (fast != null && slow != null) {

            if(fast == slow){
                System.out.println("有环");
                break;
            }
            fast = fast.next.next;
            slow = slow.next;
        }

        System.out.println("没环");

    }
}
