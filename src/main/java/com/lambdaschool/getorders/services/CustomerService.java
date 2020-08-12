package com.lambdaschool.getorders.services;

import com.lambdaschool.getorders.models.Customer;
import com.lambdaschool.getorders.views.OrderCount;

import java.util.List;

public interface CustomerService {
    List<Customer> listAllCustomerOrders();
    Customer findCustomerById(long id);
    List<Customer> listCustomerByLikeName(String thename);
    List<OrderCount> getOrderCount();
}
