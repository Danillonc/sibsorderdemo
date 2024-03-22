package com.sibs.orderdemo.application.controller;

import com.sibs.orderdemo.application.request.OrderDto;
import com.sibs.orderdemo.domain.service.OrderService;
import com.sibs.orderdemo.util.OrderDtoConverter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/create")
    public ResponseEntity<OrderDto> createOrder(@RequestBody final OrderDto orderDto) {
        OrderDto dto = OrderDtoConverter.convertFromDomain(
                this.orderService.createOrder(OrderDtoConverter.convertFromDto(orderDto)));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PutMapping("/uodate/{orderId}")
    public ResponseEntity<Void> updateOrder(@PathVariable long orderId, @RequestBody final OrderDto orderDto) {
        this.orderService.updateOrder(orderId, OrderDtoConverter.convertFromDto(orderDto));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/update/complete/{orderId}")
    public ResponseEntity<Void> completeOrder(@PathVariable long orderId){
        this.orderService.completeOrder(orderId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable long orderId){
        this.orderService.deleteOrder(orderId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
