package com.th.designPattern.bridge;

import com.th.designPattern.decorator.Sourceable;

/**
 * Created by tianhui on 16/9/13.
 */
public class BridgeTest {
    public static void main(String[] args) {
        Sourceable sourceOne = new SourceOne();
        Sourceable sourceTwo = new SourceTwo();
        Bridge bridge = new MyBridge();

        bridge.setSource(sourceOne);
        bridge.method();

        System.out.println("================");

        bridge.setSource(sourceTwo);
        bridge.method();
    }
}
