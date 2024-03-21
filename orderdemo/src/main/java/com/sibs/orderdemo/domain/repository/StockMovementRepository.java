package com.sibs.orderdemo.domain.repository;

import com.sibs.orderdemo.domain.entity.StockMovement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Interface that represents Stock Items repository operations.
 */
public interface StockMovementRepository extends JpaRepository<StockMovement, Long> {
    Optional<StockMovement> findByItemId(long id);
}
