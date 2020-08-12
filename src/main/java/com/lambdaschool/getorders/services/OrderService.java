package com.lambdaschool.getorders.services;

import com.lambdaschool.getorders.models.Order;

public interface OrderService {
    Order findOrderById(long id);

}
