package com.janowik.maclab.OrderService;

import com.janowik.maclab.Model.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImplementation implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImplementation(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void saveOrder(Order order) {
        Order newOrder = Order.builder()
                .dateOfReport(order.getDateOfReport())
                .dateOfNotification(order.getDateOfNotification())
                .deviceDescription(order.getDeviceDescription())
                .serialImeiNumber(order.getSerialImeiNumber())
                .problemDescription(order.getProblemDescription())
                .repairDescription(order.getRepairDescription())
                .comments(order.getComments())
                .name(order.getName())
                .lastName(order.getLastName())
                .phoneNumber(order.getPhoneNumber())
                .email(order.getEmail())
                .build();
        orderRepository.save(newOrder);
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
                .name(order.getName())
                .lastName(order.getLastName())
                .phoneNumber(order.getPhoneNumber())
                .email(order.getEmail())
                .build();
        orderRepository.save(updateOrder);
    }

    @Override
    public Order findOrderByEmail(String emil) {
        return orderRepository.findOrderByEmail(emil);
    }

    @Override
    public Order findOrderByNumber(String number) {
        return orderRepository.findOrderByPhoneNumber(number);
    }

    @Override
    public Order findOrderById(Long id) {
        return orderRepository.findOrderById(id);
    }
}
