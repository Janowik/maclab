package com.janowik.maclab.OrderService;

import com.janowik.maclab.Model.Order;
import org.springframework.stereotype.Service;

@Service("orderService")
public interface OrderService {
    void saveOrder(Order order);
    void updateOrder(long id, Order order);
    Order findOrderByEmail(String emil);
    Order findOrderByNumber(String number);
    Order findOrderById(Long id);
}
