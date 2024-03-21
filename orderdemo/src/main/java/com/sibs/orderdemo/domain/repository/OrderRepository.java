package com.sibs.orderdemo.domain.repository;

import com.sibs.orderdemo.domain.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Interface that represents Order repository operations.
 */
public interface OrderRepository extends JpaRepository<Order, Long> {
    public Optional<Order> findTopByOrderByCreationDateDesc();
}
