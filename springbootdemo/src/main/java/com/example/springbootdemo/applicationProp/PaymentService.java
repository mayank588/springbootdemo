package com.example.springbootdemo.applicationProp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component

public class PaymentService {
    private String type;

    private PaymentProperties paymentProperties;

    public PaymentService(PaymentProperties paymentProperties) {
        this.paymentProperties = paymentProperties;
    }


    public String getType() {
        return paymentProperties.getType();
    }

    public int getAmount() {
        return paymentProperties.getAmount();
    }

    public boolean isEnable() {
        return paymentProperties.getEnable();
    }


//    public PaymentService(@Value("${PaymentService.type}") String type,@Value("${PaymentService.amount}")int  amount) {
//        this.amount = amount;
//        this.type = type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//
//
//    private int amount;
//
//
//    public void setAmount(int amount) {
//        this.amount = amount;
//    }
//    public int getAmount() {
//        return amount;
//    }
//
//
 public void print(){
     System.out.println(getAmount());
     System.out.println(getType());
     System.out.println(isEnable());
 }
//

}
