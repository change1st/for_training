package com.th.designPattern.abstractFactory;

import com.th.designPattern.statcFactory.Sender;

/**
 * Created by tianhui on 16/9/5.
 */
public interface Provider {
    public Sender produce();
}
