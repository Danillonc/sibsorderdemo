package com.sibs.orderdemo.domain.service.impl;

import com.sibs.orderdemo.domain.entity.StockMovement;
import com.sibs.orderdemo.domain.repository.StockMovementRepository;
import com.sibs.orderdemo.domain.service.StockMovementService;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class StockMovementServiceImpl implements StockMovementService {

    private final StockMovementRepository stockMovementRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(StockMovementServiceImpl.class);

    public StockMovementServiceImpl(StockMovementRepository stockMovementRepository) {
        this.stockMovementRepository = stockMovementRepository;
    }

    @Override
    public Optional<StockMovement> getStockMovementById(long id) {
        return this.stockMovementRepository.findById(id);
    }

    @Override
    public Optional<StockMovement> getStockMovementByItemId(long id) {
        return this.stockMovementRepository.findByItemId(id);
    }

    @Override
    public StockMovement createStock(final StockMovement stockMovement) {
        return this.stockMovementRepository.saveAndFlush(stockMovement);
    }

    @Override
    public void updateStock(final StockMovement stockMovement, long stockId) {
        this.stockMovementRepository.findById(stockId)
                .ifPresentOrElse(stock -> {
                            stock.setQuantity(stockMovement.getQuantity());
                            stock.setItem(stockMovement.getItem());
                            StockMovement stockDb = this.stockMovementRepository.saveAndFlush(stock);
                            LOGGER.info("StockMovement Updated: {}", stockDb);
                        },
                        () -> {
                            LOGGER.error("StockMovement cannot be updated!");
                            throw new EntityNotFoundException("Stock cannot be updated.");
                        });

    }

    @Override
    public Optional<StockMovement> getStockMovement(long stockId) {
        return this.stockMovementRepository.findById(stockId);
    }

    @Override
    public void deleteStockMovement(long stockId) {
        this.stockMovementRepository.findById(stockId)
                .ifPresentOrElse(stock -> {
                            this.stockMovementRepository.deleteById(stockId);
                        },
                        () -> {
                            throw new EntityNotFoundException("Stock cannot be deleted.");
                        });
    }
}
