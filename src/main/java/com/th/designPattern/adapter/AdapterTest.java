package com.th.designPattern.adapter;

/**
 * Created by tianhui on 16/9/13.
 */
public class AdapterTest {
    public static void main(String[] args) {
        Adapter adapter = new Adapter();
        adapter.method1();
        adapter.method2();

        System.out.println("=========================");

        Source source = new Source();
        Wrapper wrapper = new Wrapper(source);
        wrapper.method1();
        wrapper.method2();

        System.out.println("=========================");

        Sourceable sourceable1 = new SourceSubOne();
        Sourceable sourceable2 = new SourceSubTwo();
        sourceable1.method1();
        sourceable1.method2();
        sourceable2.method1();
        sourceable2.method2();
    }
}
