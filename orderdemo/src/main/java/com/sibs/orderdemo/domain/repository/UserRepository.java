package com.sibs.orderdemo.domain.repository;

import com.sibs.orderdemo.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface that represents user repository operations.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
