package com.sibs.orderdemo.domain.service.impl;

import com.sibs.orderdemo.domain.entity.User;
import com.sibs.orderdemo.domain.repository.UserRepository;
import com.sibs.orderdemo.domain.service.UserService;
import jakarta.persistence.EntityNotFoundException;

import java.util.Optional;

public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<User> createUSer(final User user) {
        User userDb = this.repository.saveAndFlush(user);
        return Optional.of(userDb);
    }

    @Override
    public Optional<User> getUser(Integer userId) {
        return this.repository.findById(userId.longValue());
    }

    @Override
    public void updateUser(final User user, long userId) {
        this.repository.findById(userId)
                .ifPresentOrElse(userDb -> {
                            userDb.setName(user.getName());
                            userDb.setEmail(user.getEmail());
                            this.repository.saveAndFlush(userDb);
                        },
                        () -> {
                            throw new EntityNotFoundException("User not found.");
                        });
    }

    @Override
    public void deleteUser(long userId) {
        this.repository.findById(userId)
                .ifPresentOrElse(userDb -> {
                            this.repository.deleteById(userId);
                        },
                        () -> {
                            throw new EntityNotFoundException("Cannot delete user.");
                        });
    }


}
