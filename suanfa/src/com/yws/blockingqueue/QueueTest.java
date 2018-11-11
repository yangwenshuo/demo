package com.yws.blockingqueue;

import com.sun.deploy.security.BlacklistedCerts;

import javax.sound.midi.Soundbank;

public class QueueTest {
    public static void main(String[] args) throws InterruptedException {

        BlockQueue<Integer> blockQueue = new BlockQueue<>();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    while(true){
                        blockQueue.pushQueue(1);

                        //Thread.currentThread().sleep(1000);
                    }


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();


        Thread.currentThread().sleep(1500);

        blockQueue.popQueue();

        //注意我们signal唤醒了那边等待的线程后,他还是要去竞争锁的,竞争到锁了就去执行.
        //竞争不到锁了,那么就会由刚才的等待状态进入到阻塞状态


        blockQueue.popQueue();
        blockQueue.popQueue();
        blockQueue.popQueue();




    }
}
