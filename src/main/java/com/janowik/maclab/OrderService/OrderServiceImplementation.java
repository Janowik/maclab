package com.janowik.maclab.OrderService;

import com.janowik.maclab.Model.Order;

public class OrderServiceImplementation implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImplementation(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void saveOrder(Order order) {
        orderRepository.save(order);
    }

    @Override
    public void updateOrder(long id, Order order) {
        Order updateOrder = Order.builder()
                .id(id)
                .dateOfNotification(order.getDateOfNotification())
                .deviceDescription(order.getDeviceDescription())
                .problemDescription(order.getProblemDescription())
                .repairDescription(order.getRepairDescription())
                .email(order.getEmail())
                .serialImeiNumber(order.getSerialImeiNumber())
                .name(order.getName())
                .lastname(order.getLastname())
                .number(order.getNumber())
                .build();
        orderRepository.save(updateOrder);
    }

    @Override
    public Order findOrderByEmail(String emil) {
        return orderRepository.findOrderByEmail(emil);
    }

    @Override
    public Order findOrderByNumber(String number) {
        return orderRepository.findOrderByNumber(number);
    }

    @Override
    public Order findOrderById(Long id) {
        return orderRepository.findOrderById(id);
    }
}
