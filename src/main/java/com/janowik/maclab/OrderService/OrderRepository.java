package com.janowik.maclab.OrderService;

import com.janowik.maclab.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Order findOrderByEmail(String emil);
    Order findOrderByNumber(String number);
    Order findOrderById(Long id);
}
