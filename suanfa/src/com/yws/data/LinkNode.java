package com.yws.data;

public class LinkNode {

    public String value = null;

    public LinkNode next = null;

    public LinkNode(String value) {
        this.value = value;

    }

    public static LinkNode getLinkList() {

        LinkNode linkNode = new LinkNode("杨过");
        LinkNode linkNode1 = new LinkNode("赵信");
        LinkNode linkNode2 = new LinkNode("盖伦");
        LinkNode linkNode3 = new LinkNode("小龙女");
        LinkNode linkNode4 = new LinkNode("杨逍");
        LinkNode linkNode5 = new LinkNode("范谣");
        LinkNode linkNode6 = new LinkNode("金毛狮王");
        LinkNode linkNode7 = new LinkNode("文泰来");

        linkNode.next = linkNode1;
        linkNode1.next = linkNode2;
        linkNode2.next = linkNode3;
        linkNode3.next = linkNode4;
        linkNode4.next = linkNode5;
        linkNode5.next = linkNode6;
        linkNode6.next = linkNode7;
        linkNode7.next = null;

        return linkNode1;

    }

    public static void show(LinkNode linkNode){

        while(linkNode!=null){
            System.out.println(linkNode.value);
            linkNode = linkNode.next;

        }

    }

}
