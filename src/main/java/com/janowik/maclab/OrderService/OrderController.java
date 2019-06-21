package com.janowik.maclab.OrderService;

import com.janowik.maclab.Model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/orders")
public class OrderController {


    private final OrderService orderService;
    private final OrderRepository orderRepository;

    @Autowired
    public OrderController(OrderService orderService, OrderRepository orderRepository) {
        this.orderService = orderService;
        this.orderRepository = orderRepository;
    }

    @PostMapping
    private ResponseEntity saveOrder(Order order){
        orderService.saveOrder(order);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private Optional<Order> getById(@PathVariable("id") Long id){
        return Optional.ofNullable(orderService.findOrderById(id));
    }

    @GetMapping
    private List<Order> findAll(){
        return orderRepository.findAll();
    }
}
