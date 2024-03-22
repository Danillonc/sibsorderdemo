package com.sibs.orderdemo.util;

import com.sibs.orderdemo.application.request.ItemDto;
import com.sibs.orderdemo.application.request.OrderDto;
import com.sibs.orderdemo.application.request.UserDto;
import com.sibs.orderdemo.domain.entity.Item;
import com.sibs.orderdemo.domain.entity.Order;
import com.sibs.orderdemo.domain.entity.User;

public final class OrderDtoConverter {

    private OrderDtoConverter() {
    }

    public static Order convertFromDto(OrderDto orderDto) {
        return new Order(orderDto.getQuantity(), new Item(orderDto.getItem().getName(),
                orderDto.getItem().getId()), new User(orderDto.getUser().getName(), orderDto.getUser().getEmail(), orderDto.getUser().getId()));
    }

    public static OrderDto convertFromDomain(Order order) {
        ItemDto itemDto = getItemDto(order);
        UserDto userDto = getUserDto(order);
        return OrderDto.builder().item(itemDto).user(userDto)
                .quantity(order.getQuantity()).build();
    }

    private static ItemDto getItemDto(Order order) {
        return ItemDto.builder().id(order.getOrderItem().getId())
                .name(order.getOrderItem().getName()).build();
    }

    private static UserDto getUserDto(Order order) {
        return UserDto.builder().id(order.getUser().getId())
                .name(order.getUser().getName()).email(order.getUser().getEmail()).build();
    }

}
