package com.th.designPattern.proxy;

import com.th.designPattern.decorator.Source;
import com.th.designPattern.decorator.Sourceable;

/**
 * Created by tianhui on 16/9/13.
 */
public class Proxy implements Sourceable {

    private Source source;

    public Proxy() {
        super();
        this.source = new Source();
    }

    @Override
    public void method() {
        before();
        source.method();
        after();
    }

    private void before() {
        System.out.println("before");
    }

    private void after() {
        System.out.println("after");
    }
}
