package com.th.designPattern.abstractFactory;

import com.th.designPattern.statcFactory.MailSender;
import com.th.designPattern.statcFactory.Sender;

/**
 * Created by tianhui on 16/9/5.
 */
public class SendMailFactory implements Provider {
    public Sender produce() {
        return new MailSender();
    }
}
