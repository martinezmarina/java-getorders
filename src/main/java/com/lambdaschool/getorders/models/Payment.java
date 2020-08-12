package com.lambdaschool.getorders.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long paymentid;
    @Column(nullable = false, unique = true)
    private String type;

    @ManyToMany(mappedBy = "payments")
    private List<Order> orders = new ArrayList<>();

    public Payment() {
    }

    public Payment(String type) {
        this.type = type;
    }

    public long getPaymentid() {
        return paymentid;
    }

    public void setPaymentid(long paymentid) {
        this.paymentid = paymentid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
    @Override
    public String toString() {
        return "Payment{" +
                "paymentid=" + paymentid +
                ", type='" + type + '\'' +
                ", orders=" + orders +
                '}';
    }
}
