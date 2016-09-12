package com.th.designPattern.bridge;

/**
 * Created by tianhui on 16/9/13.
 */
public class MyBridge extends Bridge {
    public void method() {
        getSource().method();
    }
}
