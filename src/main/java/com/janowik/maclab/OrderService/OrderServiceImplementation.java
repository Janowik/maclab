package com.janowik.maclab.OrderService;

import com.janowik.maclab.Model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImplementation implements OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImplementation(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void saveOrder(Order order) {
        Order createOrder = Order.builder()
                .dateOfReport(order.getDateOfReport())
                .dateOfNotification(order.getDateOfNotification())
                .deviceDescription(order.getDeviceDescription())
                .serialImeiNumber(order.getSerialImeiNumber())
                .problemDescription(order.getProblemDescription())
                .repairDescription(order.getRepairDescription())
                .comments(order.getComments())
                .person(order.getPerson())
                .build();
        orderRepository.save(createOrder);
    }

    @Override
    public void updateOrder(long id, Order order) {
        Order updateOrder = Order.builder()
                .id(id)
                .dateOfReport(order.getDateOfReport())
                .dateOfNotification(order.getDateOfNotification())
                .deviceDescription(order.getDeviceDescription())
                .serialImeiNumber(order.getSerialImeiNumber())
                .problemDescription(order.getProblemDescription())
                .repairDescription(order.getRepairDescription())
                .comments(order.getComments())
                .person(order.getPerson())
                .build();
        orderRepository.save(updateOrder);
    }

    @Override
    public Order findOrderByEmail(String emil) {
        return null;
    }

    @Override
    public Order findOrderByNumber(String number) {
        return null;
    }

    @Override
    public Order findOrderById(Long id) {
        return orderRepository.findOrderById(id);
    }
}
