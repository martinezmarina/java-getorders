package com.lambdaschool.getorders.services;

import com.lambdaschool.getorders.models.Customer;
import com.lambdaschool.getorders.repositories.CustomersRepository;
import com.lambdaschool.getorders.views.OrderCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service(value = "customerService")
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomersRepository custrepos;

    @Override
    public List<Customer> listAllCustomerOrders() {
        List<Customer> rtnList = new ArrayList<>();

        custrepos.findAll()
                .iterator()
                .forEachRemaining(rtnList::add);

        return rtnList;
    }

    @Override
    public Customer findCustomerById(long id) {
        return custrepos.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Customer " + id + " Not Found"));
    }

    @Override
    public List<Customer> listCustomerByLikeName(String thename) {
        return custrepos.findByCustnameContainingIgnoringCase(thename);
    }
    @Override
    public List<OrderCount> getOrderCount() {
        return custrepos.getOrderCount();
    }
}
