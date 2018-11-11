package com.yws.blockingqueue;

import java.time.temporal.ValueRange;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockQueue<T>{

    //这里不能定义泛型数组,而是定义object的
    private Object[] valueArr = new Object[10];

    ReentrantLock lock = new ReentrantLock();
    Condition isNull = lock.newCondition();
    Condition isFull = lock.newCondition();

    private int pushpoint = 0;
    private int poppoint = 0;

    private int count = 0;

    public boolean pushQueue(T t) throws InterruptedException {

        lock.lock();

        if(count == valueArr.length){
            System.out.println("已经满了 等待吧");
            isFull.await();
        }

        pushpoint = pushpoint%(valueArr.length);

        valueArr[pushpoint] = t;

        pushpoint++;

        count++;

        isNull.signal();
        System.out.println("添加成功了一个");
        lock.unlock();

        return true;
    }

    public T popQueue() throws InterruptedException {

        lock.lock();

        if (count == 0){
            System.out.println("已经空了 等待吧");
            isNull.await();
        }

        T t = null;

        poppoint = poppoint%(valueArr.length);

        t = (T)valueArr[poppoint];

        valueArr[poppoint] = null;

        poppoint++;

        count--;

        isFull.signal();
        System.out.println("删除成功了一个");
        lock.unlock();
        return t;

    }

    public void showQueue(){
        for (int i = 0; i<valueArr.length;i++){

            System.out.println("第" + i + "位" + "是" + valueArr[i]);

        }
    }

}
