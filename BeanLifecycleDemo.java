package com.santhosh.springcore;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
class LifecycleBean {

    @PostConstruct
    public void init() {
        System.out.println("Bean initialization");
    }

    public void work() {
        System.out.println("Bean is working");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Bean destruction");
    }
}

@Configuration
@ComponentScan("com.santhosh.springcore")
class LifecycleConfig {
}

public class BeanLifecycleDemo {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(LifecycleConfig.class);
        context.getBean(LifecycleBean.class).work();
        context.close();
    }
}
