package com.th.designPattern.bridge;

import com.th.designPattern.decorator.Sourceable;

/**
 * Created by tianhui on 16/9/13.
 */
public abstract class Bridge {
    private Sourceable source;

    public void method() {
        source.method();
    }

    public Sourceable getSource() {
        return source;
    }

    public void setSource(Sourceable source) {
        this.source = source;
    }
}
