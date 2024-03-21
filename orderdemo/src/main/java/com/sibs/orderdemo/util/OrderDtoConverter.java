package com.sibs.orderdemo.util;

import com.sibs.orderdemo.application.request.ItemDto;
import com.sibs.orderdemo.application.request.OrderDto;
import com.sibs.orderdemo.domain.entity.Item;
import com.sibs.orderdemo.domain.entity.Order;
import com.sibs.orderdemo.domain.entity.User;

public final class OrderDtoConverter {

    private OrderDtoConverter(){}
    public static Order convertFromDto(OrderDto orderDto){
        return new Order(orderDto.getQuantity(), new Item(orderDto.getItem().getName(),
                orderDto.getItem().getId()), new User(orderDto.getUser().getName(), orderDto.getUser().getEmail(), orderDto.getUser().getId()));
    }


    public static Item convertToAddItemDomain(final ItemDto itemDto){
        return new Item(itemDto.getName());
    }


}
