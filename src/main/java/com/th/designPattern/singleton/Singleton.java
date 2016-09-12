package com.th.designPattern.singleton;

/**
 * Created by tianhui on 16/9/5.
 */
public class Singleton {
    private static Singleton instance = null;

    private Singleton() {

    }

    /**
     * 懒汉
     * @return
     */
    public static Singleton getInstance() {
        if(instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public void outPut() {
        System.out.println("this is singleton");
    }

    /**
     * 饿汉模式
     */
    private static class SingletonFactory {
        private static final Singleton instance = new Singleton();
    }

    static Singleton getInstance1() {
            return SingletonFactory.instance;
    }

    /**
     *  如果该对象被用于序列化，可以保证对象在序列化前后保持一致
     */
    public Object readResolve() {
        return instance;
    }
}
