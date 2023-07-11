package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "your.package.name")
public class AppConfig {

    @Bean
    public PaymentService paymentService() {
        return new PaymentService();
    }

    @Bean
    public Cash cash() {
        return new Cash();
    }

    @Bean Card card() {
        return new Card();
    }

    @Bean
    public Check check() {
        return new Check();
    }

}
