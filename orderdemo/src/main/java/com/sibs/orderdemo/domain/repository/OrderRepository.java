package com.sibs.orderdemo.domain.repository;

import com.sibs.orderdemo.domain.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Interface that represents Order repository operations.
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    public Optional<Order> findTopByOrderByCreationDateDesc();
}
