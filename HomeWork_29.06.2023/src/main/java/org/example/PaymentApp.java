package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PaymentApp {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ClassPathXmlApplicationContext pathContext = new ClassPathXmlApplicationContext("resources.xml");
        PaymentService paymentService = context.getBean(PaymentService.class);

        PaymentService paymentServiceByPath = (PaymentService) pathContext.getBean("paymentService");

        System.out.println("Context with using @Been\n");
        paymentServiceByPath.pay(PaymentType.CARD);
        paymentServiceByPath.pay(PaymentType.CASH);
        paymentServiceByPath.pay(PaymentType.CHECK);

        System.out.println("-------------------------");

        System.out.println("Context with using @Context\n");
        paymentService.pay(PaymentType.CARD);
        paymentService.pay(PaymentType.CASH);
        paymentService.pay(PaymentType.CHECK);
    }
}
