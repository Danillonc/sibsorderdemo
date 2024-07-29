package com.sibs.orderdemo.domain.repository;

import com.sibs.orderdemo.domain.entity.StockMovement;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Interface that represents Stock Items repository operations.
 */
@Repository
public interface StockMovementRepository extends JpaRepository<StockMovement, Long> {
    Optional<StockMovement> findByItemId(long id);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT s FROM StockMovement s WHERE s.item.id = :itemId")
    Optional<StockMovement> findByItemIdWithLock(long itemId);
}
