package com.yws.erchashubianli;

import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Client {

    public static Queue<TreeNode> queue = new ArrayBlockingQueue<TreeNode>(20);

    public static void main(String[] args) {
        TreeNode<String> treeNode = new TreeNode<>("龙儿");
        TreeNode<String> treeNode1 = new TreeNode<>("聂风");
        TreeNode<String> treeNode2 = new TreeNode<>("步惊云");
        treeNode.leftchild = treeNode1;
        treeNode.rightchild = treeNode2;
        TreeNode<String> treeNode11 = new TreeNode<>("明月");
        TreeNode<String> treeNode12 = new TreeNode<>("第二梦");

        TreeNode<String> treeNode21 = new TreeNode<>("孔慈");
        TreeNode<String> treeNode22 = new TreeNode<>("楚楚");

        treeNode1.leftchild = treeNode11;
        treeNode1.rightchild = treeNode12;

        treeNode2.leftchild = treeNode21;
        treeNode2.rightchild = treeNode22;

        TreeNode<String> treeNode122 = new TreeNode<>("易风");

        TreeNode<String> treeNode1222 = new TreeNode<>("易天涯");
        treeNode122.rightchild = treeNode1222;

        treeNode12.leftchild = treeNode122;

        //xianGen(treeNode);
        //zhonggen(treeNode);
        //hougen(treeNode);
        //cengji(treeNode);
        cengjiXunHuanRightView(treeNode);
        leftView(treeNode);
    }

    public static void xianGen(TreeNode<String> treeNode) {

        if (treeNode == null) {
            return;
        }

        System.out.println(treeNode.data);

        if (treeNode.leftchild != null) {
            xianGen(treeNode.leftchild);
        }

        if (treeNode.rightchild != null) {
            xianGen(treeNode.rightchild);
        }

    }

    public static void zhonggen(TreeNode<String> treeNode) {
        if (treeNode == null) {
            return;
        }

        if (treeNode.leftchild != null) {
            zhonggen(treeNode.leftchild);
        }

        if (treeNode.rightchild != null) {
            zhonggen(treeNode.rightchild);
        }

        System.out.println(treeNode.data);

    }

    public static void hougen(TreeNode<String> treeNode) {
        if (treeNode == null) {
            return;
        }

        if (treeNode.leftchild != null) {
            hougen(treeNode.leftchild);
        }

        if (treeNode.rightchild != null) {
            hougen(treeNode.rightchild);
        }

        System.out.println(treeNode.data);

    }

    //使用队列迭代实现层级遍历
    public static void cengji(TreeNode<String> treeNode) {

        if (treeNode == null) {
            return;
        }
        System.out.println(treeNode.data);

        if (treeNode.leftchild != null) {
            queue.offer(treeNode.leftchild);
        }

        if (treeNode.rightchild != null) {
            queue.offer(treeNode.rightchild);
        }

        TreeNode node = queue.poll();

        cengji(node);

    }

    //迭代也可以实现的  这个就直接弄左视图了
    public static void cengjiXunHuanRightView(TreeNode<String> treeNode) {

        queue.offer(treeNode);

        ArrayList<String> arrayList = new ArrayList<>();

        int nextnum = 0;
        int thisnum = 1;

        while (queue.size() > 0) {

            TreeNode node = queue.poll();
            thisnum--;

         //   System.out.println(node.data);


            if (node.leftchild != null) {
                queue.offer(node.leftchild);
                nextnum++;
            }

            if (node.rightchild != null) {
                queue.offer(node.rightchild);
                nextnum++;
            }

            if (thisnum == 0) {//如果thisnum等于0,说明是最后一个
                arrayList.add((String) node.data);
                thisnum = nextnum;
                nextnum = 0;
            }

        }

        for (String s:arrayList){
            System.out.println(s);
        }

    }

    public static void leftView(TreeNode<String> treeNode){

        queue.offer(treeNode);

        ArrayList<String> arrayList = new ArrayList<>();

        int nextnum = 0;
        int thisnum = 1;
        int flag = 1;

        //这个题  如果是nextnum==0的话 有一种情况是第一个,也有可能是前面的没有给nextnum加,
        //前面的没有加子节点,所以我们要加一个标志位

        while(queue.size() > 0){

            TreeNode node = queue.poll();

            if(nextnum == 0 && flag == 1){
                //如果下一个是0的话 不说明这就是第一个,因为可能是前面的没给后面加东西

                System.out.println("添加" + node.data);
                arrayList.add((String) node.data);
                flag = 0;
            }

            thisnum--;



            if (node.leftchild != null) {
                queue.offer(node.leftchild);
                nextnum++;
            }

            if (node.rightchild != null) {
                queue.offer(node.rightchild);
                nextnum++;
            }



            if(thisnum == 0){
                thisnum = nextnum;
                nextnum = 0;
                flag = 1;
            }

        }

        for (String s:arrayList){
            System.out.println(s);
        }


    }
}
