package com.santhosh.springcore;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

interface PaymentService {
    void pay();
}

@Component
class UpiPaymentService implements PaymentService {
    public void pay() {
        System.out.println("Payment completed using UPI");
    }
}

@Component
class OrderService {
    private final PaymentService paymentService;

    OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    void placeOrder() {
        paymentService.pay();
        System.out.println("Order placed");
    }
}

@Configuration
@ComponentScan("com.santhosh.springcore")
class AutowireConfig {
}

public class AutowiringDemo {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(AutowireConfig.class);
        context.getBean(OrderService.class).placeOrder();
        context.close();
    }
}
