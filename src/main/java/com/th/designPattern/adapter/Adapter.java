package com.th.designPattern.adapter;

/**
 * Created by tianhui on 16/9/13.
 */
public class Adapter extends Source implements Targetable {
    public void method2() {
        System.out.println("this is target method!");
    }
}