package com.sibs.orderdemo.domain.service.impl;

import com.sibs.orderdemo.domain.entity.Order;
import com.sibs.orderdemo.domain.entity.StockMovement;
import com.sibs.orderdemo.domain.exception.DomainException;
import com.sibs.orderdemo.domain.repository.OrderRepository;
import com.sibs.orderdemo.domain.service.OrderService;
import com.sibs.orderdemo.domain.service.StockMovementService;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final StockMovementService stockService;
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);

    public OrderServiceImpl(OrderRepository orderRepository, StockMovementService stockService) {
        this.orderRepository = orderRepository;
        this.stockService = stockService;
    }

    @Override
    public Order createOrder(Order order) {
        Order createdOrder;
        try {
            verifyOrderStock(order);
            updateOrderStockItem(order);
            createdOrder = this.orderRepository.saveAndFlush(order);
            LOGGER.info("Order created: {}", order);
        } catch (Exception e) {
            throw e;
        }
        return createdOrder;
    }

    @Override
    public void updateOrder(long orderId, final Order order) {
        this.orderRepository.findById(orderId)
                .ifPresentOrElse(o -> {
                            o.validateStatus();
                            o.setQuantity(order.getQuantity());
                            o.setOrderItem(order.getOrderItem());
                            o.setUser(order.getUser());
                            LOGGER.info("Order updated: {}", o);
                            this.orderRepository.saveAndFlush(o);
                        },
                        () -> {
                            throw new EntityNotFoundException("Order cannot be updated.");
                        });

    }


    @Override
    public void completeOrder(long orderId) {
        this.orderRepository.findById(orderId)
                .ifPresentOrElse(o -> {
                    o.complete();
                    LOGGER.info("Order completed: {}", o);
                    this.orderRepository.saveAndFlush(o);
                }, () -> {
                    throw new EntityNotFoundException("Order cannot be completed.");
                });
    }

    @Override
    public void deleteOrder(long orderId) {
        this.orderRepository.findById(orderId)
                .ifPresentOrElse(o -> {
                    this.orderRepository.deleteById(orderId);
                }, () -> {
                    throw new EntityNotFoundException("Order cannot be deleted.");
                });

    }

    private void verifyOrderStock(final Order order) {
        final Optional<StockMovement> stockMovement = this.stockService.getStockMovementByItemId(order.getOrderItem().getId());
        stockMovement.ifPresentOrElse(stock -> {
                    if (stock.getQuantity() < order.getQuantity()) {
                        throw new DomainException("Stock unavaible for Order quantity!");
                    }
                },
                () -> {
                    throw new EntityNotFoundException("Not exist item Stock.");
                });
    }

    private void updateOrderStockItem(final Order order) {
        var stockItemQuantity = 0;
        final Optional<StockMovement> stockMovement = this.stockService.getStockMovementByItemId(order.getOrderItem().getId());
        if (stockMovement.isPresent()) {
            LOGGER.info("StockMovement: {}", stockMovement.get());
            stockItemQuantity = stockMovement.get().getQuantity() - order.getQuantity();
            stockMovement.get().setQuantity(stockItemQuantity);
        }
        this.stockService.updateStock(stockMovement.get(), stockMovement.get().getId());
    }

}
