package com.sibs.orderdemo.domain.service;

import com.sibs.orderdemo.domain.entity.User;

import java.util.Optional;

public interface UserService {
    public Optional<User> createUSer(final User user);

    Optional<User> getUser(Integer userId);

    void updateUser(User user, long userId);

    void deleteUser(long userId);
}
