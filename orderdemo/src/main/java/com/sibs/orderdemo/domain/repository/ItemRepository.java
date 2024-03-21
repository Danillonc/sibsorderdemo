package com.sibs.orderdemo.domain.repository;

import com.sibs.orderdemo.domain.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface that represents Item repository operations.
 */
public interface ItemRepository extends JpaRepository<Item, Long> {

}
