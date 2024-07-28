package com.sibs.orderdemo.util;

import com.sibs.orderdemo.application.request.StockMovementRecord;
import com.sibs.orderdemo.domain.entity.Item;
import com.sibs.orderdemo.domain.entity.StockMovement;

public class StockDtoConverter {

    private StockDtoConverter(){}

    public static StockMovement convertToDomain(final StockMovementRecord stockDto){
        return new StockMovement(stockDto.quantity(), new Item(null, stockDto.itemId()));
    }

    public static StockMovementRecord convertToDto(final StockMovement stockMovement){
        return new StockMovementRecord(stockMovement.getQuantity(), stockMovement.getId());
    }
}
