package com.th.designPattern.bridge;

import com.th.designPattern.decorator.Sourceable;

/**
 * Created by tianhui on 16/9/13.
 */
public class SourceTwo implements Sourceable {
    @Override
    public void method() {
        System.out.println("this is two");
    }
}
