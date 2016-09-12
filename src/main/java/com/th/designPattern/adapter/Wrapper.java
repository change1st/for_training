package com.th.designPattern.adapter;

/**
 * Created by tianhui on 16/9/13.
 */
public class Wrapper implements Targetable{
    private Source source;
    public Wrapper (Source source) {
        super();
        this.source = source;
    }

    @Override
    public void method1() {
        source.method1();
    }

    @Override
    public void method2() {
        System.out.println("this is target method!");
    }
}
