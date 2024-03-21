package com.sibs.orderdemo.domain.repository;

import com.sibs.orderdemo.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface that represents user repository operations.
 */

public interface UserRepository extends JpaRepository<User, Long> {

}
