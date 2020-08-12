package com.lambdaschool.getorders.controllers;

import com.lambdaschool.getorders.models.Customer;
import com.lambdaschool.getorders.services.CustomerService;
import com.lambdaschool.getorders.views.OrderCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    // http://localhost:2019/customers/orders
    @GetMapping(value = "/orders", produces = {"application/json"})
    public ResponseEntity<?> listAllCustomerOrders() {
        List<Customer> customersOrders = customerService.listAllCustomerOrders();
        return new ResponseEntity<>(customersOrders, HttpStatus.OK);
    }
    // http://localhost:2019/customers/customer/7
    @GetMapping(value = "/customer/{id}", produces = {"application/json"})
    public ResponseEntity<?> findCustomerById(@PathVariable long id) {
        Customer c = customerService.findCustomerById(id);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }
    // http://localhost:2019/customers/namelike/mes
    @GetMapping(value = "/namelike/{thename}")
    public ResponseEntity<?> listCustomersByLikeName(@PathVariable String thename) {
        List<Customer> customers = customerService.listCustomerByLikeName(thename);
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
    //http://localhost:2019/customers/orders/count
    @GetMapping(value = "/orders/count", produces = "application/json")
    public ResponseEntity<?>getOrderCount(){
        List<OrderCount> orderCountList = customerService.getOrderCount();
        return new ResponseEntity<>(orderCountList, HttpStatus.OK);
    }
}
