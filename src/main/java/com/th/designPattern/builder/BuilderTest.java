package com.th.designPattern.builder;

/**
 * Created by tianhui on 16/9/7.
 */
public class BuilderTest {
    public static void main(String[] args) {
        Builder builder = new Builder();
        builder.getMailSender();
        builder.getSmsSender();
    }
}
