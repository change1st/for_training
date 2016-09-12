package com.th.designPattern.facade;

/**
 * Created by tianhui on 16/9/5.
 */
public class Sensor {
    public void activate() {
        System.out.println("开启感应器！");
    }

    public void deactivate() {
        System.out.println("关闭感应器！");
    }
}
