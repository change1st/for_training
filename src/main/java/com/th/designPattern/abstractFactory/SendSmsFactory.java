package com.th.designPattern.abstractFactory;

import com.th.designPattern.statcFactory.MailSender;
import com.th.designPattern.statcFactory.Sender;
import com.th.designPattern.statcFactory.SmsSender;

/**
 * Created by tianhui on 16/9/5.
 */
public class SendSmsFactory implements Provider{

    public Sender produce() {
        return new SmsSender();
    }
}
