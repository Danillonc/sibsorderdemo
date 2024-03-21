package com.sibs.orderdemo.domain.service;

import com.sibs.orderdemo.domain.entity.Order;

public interface OrderService {

    Order createOrder(final Order order);
    void updateOrder(long orderId, final Order order);

    void completeOrder(long orderId);

    void deleteOrder(long orderId);


}
