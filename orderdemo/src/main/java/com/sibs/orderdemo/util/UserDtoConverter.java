package com.sibs.orderdemo.util;

import com.sibs.orderdemo.application.request.UserRecord;
import com.sibs.orderdemo.domain.entity.User;

import java.util.Optional;

public final class UserDtoConverter {

    private UserDtoConverter(){

    }

    public static User convertToDomain(final UserRecord userDto){
        return new User(userDto.name(), userDto.email());
    }

    public static UserRecord convertToDto(Optional<User> user) {
        return user.map(value -> new UserRecord(value.getId(), value.getName(),
                value.getEmail())).orElse(null);
    }
}
