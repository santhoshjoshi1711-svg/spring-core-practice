package com.santhosh.springcore;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
class ScopeConfig {
    @Bean
    @Scope("singleton")
    public Object singletonBean() {
        return new Object();
    }

    @Bean
    @Scope("prototype")
    public Object prototypeBean() {
        return new Object();
    }
}

public class BeanScopeDemo {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ScopeConfig.class);

        Object s1 = context.getBean("singletonBean");
        Object s2 = context.getBean("singletonBean");
        Object p1 = context.getBean("prototypeBean");
        Object p2 = context.getBean("prototypeBean");

        System.out.println("Singleton same object: " + (s1 == s2));
        System.out.println("Prototype same object: " + (p1 == p2));

        context.close();
    }
}
