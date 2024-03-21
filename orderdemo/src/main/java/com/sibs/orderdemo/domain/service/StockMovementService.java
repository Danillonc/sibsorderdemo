package com.sibs.orderdemo.domain.service;

import com.sibs.orderdemo.domain.entity.StockMovement;

import java.util.Optional;

public interface StockMovementService {
    public Optional<StockMovement> getStockMovementById(long id);

    public Optional<StockMovement> getStockMovementByItemId(long id);

    public StockMovement createStock(final StockMovement stockMovement);

    public void updateStock(final StockMovement stockMovement, long stockId);

    public Optional<StockMovement> getStockMovement(long stockId);

    public void deleteStockMovement(long stockId);
}
