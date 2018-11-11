package com.pyg.page.service.impl;

import com.pyg.page.service.ItemPageService;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import java.io.IOException;

@Component
public class ItemPageCreateListener implements MessageListener{

    @Autowired
    private ItemPageService itemPageService;



    //yws:这里有一个onmessage方法
    @Override
    public void onMessage(Message message) {
        try {
            ObjectMessage objectMessage = (ObjectMessage) message;
            Long[] ids =  (Long[])objectMessage.getObject();
            for (Long gid : ids) {
                itemPageService.createItemHtml(gid);
            }
        } catch (JMSException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void setItemPageService(ItemPageService itemPageService) {
        this.itemPageService = itemPageService;
    }
}
