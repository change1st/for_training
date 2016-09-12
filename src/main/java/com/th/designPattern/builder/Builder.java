package com.th.designPattern.builder;

import com.th.designPattern.abstractFactory.Provider;
import com.th.designPattern.abstractFactory.SendMailFactory;
import com.th.designPattern.abstractFactory.SendSmsFactory;
import com.th.designPattern.statcFactory.Sender;

/**
 * Created by tianhui on 16/9/7.
 */
public class Builder {
    public void getSmsSender() {
        Provider sendSmsFactory = new SendSmsFactory();
        sendSmsFactory.produce().sendMsg();
    }

    public void getMailSender() {
        Provider sendMailFactory = new SendMailFactory();
        sendMailFactory.produce().sendMsg();
    }
}
