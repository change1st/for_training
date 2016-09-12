package com.th.designPattern.decorator;

import com.th.designPattern.decorator.Source;

/**
 * Created by tianhui on 16/9/13.
 */
public class DecoratorTest {
    public static void main(String[] args) {
        Source source = new Source();
        Decorator decorator = new Decorator(source);
        decorator.method();
    }
}
