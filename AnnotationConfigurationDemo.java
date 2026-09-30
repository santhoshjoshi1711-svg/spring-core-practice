package com.santhosh.springcore;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan("com.santhosh.springcore")
class AppConfig {
}

@Component
class GreetingService {
    public void greet() {
        System.out.println("Hello from annotation-based configuration");
    }
}

public class AnnotationConfigurationDemo {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(AppConfig.class);
        context.getBean(GreetingService.class).greet();
        context.close();
    }
}
