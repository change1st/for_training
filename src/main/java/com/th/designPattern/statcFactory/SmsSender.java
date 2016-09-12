package com.th.designPattern.statcFactory;

/**
 * Created by tianhui on 16/9/5.
 */
public class SmsSender implements Sender {

    public void sendMsg() {
        System.out.println("send a smsMessage");
    }
}
