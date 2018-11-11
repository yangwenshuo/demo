package com.pyg.page.service.impl;

import com.pyg.page.service.ItemPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;


@Component
public class ItemPageDeleteListener implements MessageListener{

    @Autowired
    private ItemPageService itemPageService;

    @Override
    public void onMessage(Message message) {
        // TODO Auto-generated method stub

        try {
            ObjectMessage objectMessage = (ObjectMessage) message;
            Long[] ids =  (Long[])objectMessage.getObject();
            itemPageService.removeItemHtml(ids);
        } catch (JMSException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void setItemPageService(ItemPageService itemPageService) {
        this.itemPageService = itemPageService;
    }
}
