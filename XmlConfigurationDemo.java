package com.santhosh.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlConfigurationDemo {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        MessageService service = context.getBean(MessageService.class);
        service.sendMessage();
    }
}

class MessageService {
    public void sendMessage() {
        System.out.println("Hello from Spring XML configuration");
    }
}
