package com.santhosh.springcore;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
class ApplicationInfo {
    @Value("${app.name}")
    private String appName;

    public void print() {
        System.out.println("Application: " + appName);
    }
}

@Configuration
@ComponentScan("com.santhosh.springcore")
@PropertySource("classpath:application.properties")
class PropertyConfig {
}

public class ValuePropertyDemo {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(PropertyConfig.class);
        context.getBean(ApplicationInfo.class).print();
        context.close();
    }
}
