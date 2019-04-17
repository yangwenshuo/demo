package com.yws.data;

public class LinkNode {

    public String value = null;

    public LinkNode next = null;

    public LinkNode(String value) {
        this.value = value;

    }

    public static LinkNode getLinkList() {

        LinkNode linkNode = new LinkNode("aa");
        LinkNode linkNode1 = new LinkNode("bb");
        LinkNode linkNode2 = new LinkNode("cc");
        LinkNode linkNode3 = new LinkNode("dd");
        LinkNode linkNode4 = new LinkNode("ff");
        LinkNode linkNode5 = new LinkNode("gg");
        LinkNode linkNode6 = new LinkNode("hh");
        LinkNode linkNode7 = new LinkNode("ii");

        linkNode.next = linkNode1;
        linkNode1.next = linkNode2;
        linkNode2.next = linkNode3;
        linkNode3.next = linkNode4;
        linkNode4.next = linkNode5;
        linkNode5.next = linkNode6;
        linkNode6.next = linkNode7;
        linkNode7.next = null;

        return linkNode;

    }

    public static void show(LinkNode linkNode){

        while(linkNode!=null){
            System.out.println(linkNode.value);
            linkNode = linkNode.next;

        }

    }

}
