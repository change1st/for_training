package com.th.designPattern.decorator;

import com.th.designPattern.decorator.Source;
import com.th.designPattern.decorator.Sourceable;

/**
 * Created by tianhui on 16/9/13.
 */
public class Decorator implements Sourceable {

    private Source source;

    public Decorator(Source source) {
        super();
        this.source = source;
    }

    @Override
    public void method() {
        System.out.println("begin");
        source.method();
        System.out.println("end");
    }
}
