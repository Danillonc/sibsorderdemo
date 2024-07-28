package com.sibs.orderdemo.util;

import com.sibs.orderdemo.application.request.ItemRecord;
import com.sibs.orderdemo.domain.entity.Item;

import java.util.Optional;

public class ItemDtoConverter {

    private ItemDtoConverter(){}

    public static Item convertToDomain(final ItemRecord itemDto){
         return new Item(itemDto.name());
    }

    public static ItemRecord convertToDto(Optional<Item> item){
        return item.map(value -> new ItemRecord(value.getId(), value.getName())).orElse(null);
    }

}
