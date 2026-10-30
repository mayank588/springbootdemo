
package com.example.springbootdemo;

import com.example.springbootdemo.applicationProp.PaymentProperties;
import com.example.springbootdemo.applicationProp.PaymentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;

@SpringBootApplication()
public class SpringbootdemoApplication {

    public static void main(String[] args) {
     //  ApplicationContext context=
               SpringApplication.run(SpringbootdemoApplication.class, args);
               System.out.println("Application Started");


       // PaymentService paymentService=context.getBean(PaymentService.class);
      //  PaymentProperties paymentprop=context.getBean(PaymentProperties.class);
       // paymentService.print();



    }

}
