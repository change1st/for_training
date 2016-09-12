package com.th.designPattern.decorator;

/**
 * Created by tianhui on 16/9/13.
 */
public class Source implements Sourceable {
    @Override
    public void method() {
        System.out.println("this is decorator");
    }
}
