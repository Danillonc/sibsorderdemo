package com.sibs.orderdemo.util;

import com.sibs.orderdemo.application.request.*;
import com.sibs.orderdemo.domain.entity.Item;
import com.sibs.orderdemo.domain.entity.Order;
import com.sibs.orderdemo.domain.entity.User;

public final class OrderDtoConverter {

    private OrderDtoConverter() {
    }

    public static Order convertFromDto(OrderRecord orderDto) {
        return new Order(orderDto.quantity(), new Item(orderDto.item().name(),
                orderDto.item().id()), new User(orderDto.user().name(), orderDto.user().email(), orderDto.user().id()));
    }

    public static OrderRecord convertFromDomain(Order order) {
        ItemRecord itemDto = getItemRecord(order);
        UserRecord userDto = getUserRecord(order);
        return new OrderRecord(userDto, order.getQuantity(), itemDto);
    }

    private static ItemRecord getItemRecord(Order order) {
        return new ItemRecord(order.getOrderItem().getId(),
                order.getOrderItem().getName());
    }

    private static UserRecord getUserRecord(Order order) {
        return new UserRecord(order.getUser().getId(),
                order.getUser().getName(), order.getUser().getEmail());
    }

}
