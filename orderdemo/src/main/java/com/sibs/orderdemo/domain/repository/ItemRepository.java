package com.sibs.orderdemo.domain.repository;

import com.sibs.orderdemo.domain.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface that represents Item repository operations.
 */
@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

}
