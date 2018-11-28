package com.yws.leftestlowestnode;

import com.yws.erchashubianli.TreeNode;

import java.util.Objects;

public class Test {

    private static TreeNode nodelowestleftest = null;
    private static int high = 0;



    public static void main(String[] args) {

        //该函数的目的是找到一个二叉树最下面最左面的一个节点

        TreeNode treeNode = new TreeNode("yangguo ");
        TreeNode treeNode1 = new TreeNode("zhaoxin ");
        TreeNode treeNode2 = new TreeNode("kaiyin ");
        TreeNode treeNode3 = new TreeNode("amumu ");
        TreeNode treeNode4 = new TreeNode("shizigou ");
        TreeNode treeNode5 = new TreeNode("tanglang ");
        TreeNode treeNode6 = new TreeNode("gailun ");
        TreeNode treeNode7 = new TreeNode("jiawen ");




        treeNode.leftchild = treeNode1;
        treeNode.rightchild = treeNode2;

        treeNode1.leftchild = treeNode3;
        treeNode1.rightchild = treeNode4;

        treeNode2.leftchild = treeNode5;
        treeNode2.rightchild = treeNode6;
        treeNode5.rightchild = treeNode7;

        //firtstRootTraverseTree(treeNode);

        findLeftLowNode(treeNode,1);

        System.out.println(nodelowestleftest.data);


    }


    public static void  findLeftLowNode(TreeNode node , int deep){


        if(deep>high){
            high = deep;
            nodelowestleftest = node;
        }

        if(node.leftchild!=null){
            findLeftLowNode(node.leftchild,deep+1);
        }

        if(node.rightchild!=null){
            findLeftLowNode(node.rightchild,deep+1);
        }

    }



    public static void firtstRootTraverseTree(TreeNode node){


        if(node!=null){
            System.out.println(node.data);
        }

        if(node.leftchild!=null){

            firtstRootTraverseTree(node.leftchild);

        }

        if(node.rightchild!=null){
            firtstRootTraverseTree(node.rightchild);
        }

    }
}
