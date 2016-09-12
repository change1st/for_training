package com.th.designPattern.abstractFactory;

import com.th.designPattern.statcFactory.Sender;

/**
 * Created by tianhui on 16/9/5.
 */
public class AFactoryTest {
    public static void main(String[] args) {
        Provider mailProvider = new SendMailFactory();
        Sender mailSender = mailProvider.produce();
        mailSender.sendMsg();

        Provider smsProvider = new SendSmsFactory();
        Sender smsSender = smsProvider.produce();
        smsSender.sendMsg();
    }
}
