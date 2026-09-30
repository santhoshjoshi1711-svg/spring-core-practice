package com.santhosh.springcore;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

interface MessageSender {
    void send();
}

@Component("emailSender")
class EmailSender implements MessageSender {
    public void send() {
        System.out.println("Email sent");
    }
}

@Component("smsSender")
class SmsSender implements MessageSender {
    public void send() {
        System.out.println("SMS sent");
    }
}

@Component
class AlertService {
    private final MessageSender sender;

    AlertService(@Qualifier("emailSender") MessageSender sender) {
        this.sender = sender;
    }

    void alert() {
        sender.send();
    }
}

@Configuration
@ComponentScan("com.santhosh.springcore")
class QualifierConfig {
}

public class QualifierPrimaryDemo {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(QualifierConfig.class);
        context.getBean(AlertService.class).alert();
        context.close();
    }
}
