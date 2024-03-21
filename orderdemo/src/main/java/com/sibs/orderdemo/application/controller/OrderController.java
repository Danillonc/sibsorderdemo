package com.sibs.orderdemo.application.controller;

import com.sibs.orderdemo.application.request.OrderDto;
import com.sibs.orderdemo.domain.service.OrderService;
import com.sibs.orderdemo.util.OrderDtoConverter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createOrder(@RequestBody final OrderDto orderDto){
        this.orderService.createOrder(OrderDtoConverter.convertFromDto(orderDto));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
