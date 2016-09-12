package com.th.designPattern.singleton;

/**
 * Created by tianhui on 16/9/5.
 */
public class SingletonTest {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        singleton.outPut();

        Singleton singleton1 = Singleton.getInstance1();
        singleton1.outPut();
    }
}
