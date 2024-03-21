package com.sibs.orderdemo.util;

import com.sibs.orderdemo.application.request.StockMovementDto;
import com.sibs.orderdemo.domain.entity.Item;
import com.sibs.orderdemo.domain.entity.StockMovement;

public class StockDtoConverter {

    private StockDtoConverter(){}

    public static StockMovement convertToDomain(final StockMovementDto stockDto){
        return new StockMovement(stockDto.getQuantity(), new Item(null, stockDto.getItemId()));
    }

    public static StockMovementDto convertToDto(final StockMovement stockMovement){
        return StockMovementDto.builder().quantity(stockMovement.getQuantity())
                .itemId(stockMovement.getId()).build();
    }
}
