package com.th.designPattern.statcFactory;

/**
 * Created by tianhui on 16/9/5.
 */
public class SenderFactory {

    static Sender smsProduce() {
        return new SmsSender();
    }

    static Sender mailProduce() {
        return new MailSender();
    }
}
