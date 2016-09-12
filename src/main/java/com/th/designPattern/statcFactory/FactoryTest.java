package com.th.designPattern.statcFactory;

/**
 * Created by tianhui on 16/9/5.
 */
public class FactoryTest {
    public static void main(String[] args) {
        Sender mSender = SenderFactory.mailProduce();
        mSender.sendMsg();

        Sender sSender = SenderFactory.smsProduce();
        sSender.sendMsg();
    }
}
