package com.sibs.orderdemo.util;

import com.sibs.orderdemo.application.request.UserDto;
import com.sibs.orderdemo.domain.entity.User;

import java.util.Optional;

public final class UserDtoConverter {

    private UserDtoConverter(){

    }

    public static User convertToDomain(final UserDto userDto){
        return new User(userDto.getName(), userDto.getEmail());
    }

    public static UserDto convertToDto(Optional<User> user) {
        if(user.isPresent()){
            return UserDto.builder().name(user.get().getName())
                    .email(user.get().getEmail()).id(user.get().getId()).build();
        }
        return null;
    }
}
