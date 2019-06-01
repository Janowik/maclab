package com.janowik.maclab.OrderService;

import com.janowik.maclab.Model.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/orders")
public class OrderController {

    @PostMapping
    private ResponseEntity saveOrder(Order order){
        return new Re
    }

}
