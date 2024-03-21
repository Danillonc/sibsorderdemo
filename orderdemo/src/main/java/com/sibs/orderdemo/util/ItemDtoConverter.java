package com.sibs.orderdemo.util;

import com.sibs.orderdemo.application.request.ItemDto;
import com.sibs.orderdemo.domain.entity.Item;

import java.util.Optional;

public class ItemDtoConverter {

    private ItemDtoConverter(){}

    public static Item convertToDomain(final ItemDto itemDto){
         return new Item(itemDto.getName());
    }

    public static ItemDto convertToDto(Optional<Item> item){
        if(item.isPresent()){
            return ItemDto.builder().name(item.get().getName()).id(item.get().getId()).build();
        }
        return null;
    }

}
