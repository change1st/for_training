package com.th.thread;

import java.io.IOException;

/**
 * Created by mr_change on 16-6-1.
 */
public class ThreadSleep {
    private int i = 10;
    private Object object = new Object();

    public static void main(String[] args) throws IOException {
        ThreadSleep threadSleep = new ThreadSleep();
        MyThread thread1 = threadSleep.new MyThread();
        MyThread thread2 = threadSleep.new MyThread();
        thread1.start();
        thread2.start();
    }


    class MyThread extends Thread{
        @Override
        public void run() {
            synchronized (object) {
                i++;
                System.out.println("i:"+i);
                try {
                    System.out.println("线程"+Thread.currentThread().getName()+"进入睡眠状态");
                    Thread.currentThread().sleep(10000);
                } catch (InterruptedException e) {
                    // TODO: handle exception
                }
                System.out.println("线程"+Thread.currentThread().getName()+"睡眠结束");
                i++;
                System.out.println("i:"+i);
            }
        }
    }
}
