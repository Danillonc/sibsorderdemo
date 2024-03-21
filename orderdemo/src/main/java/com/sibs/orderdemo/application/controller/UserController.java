package com.sibs.orderdemo.application.controller;

import com.sibs.orderdemo.application.request.UserDto;
import com.sibs.orderdemo.domain.service.UserService;
import com.sibs.orderdemo.util.UserDtoConverter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<UserDto> createUser(@RequestBody final UserDto userDto){
        UserDto dto =UserDtoConverter.convertToDto(this.userService
                .createUSer(UserDtoConverter.convertToDomain(userDto)));
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUser(@PathVariable Integer userId){
        return new ResponseEntity<>(UserDtoConverter.convertToDto(this.userService.getUser(userId)), HttpStatus.OK);
    }

    @PatchMapping("/update/{userId}")
    public ResponseEntity<Void> update(@RequestBody final UserDto userDto, @PathVariable long userId){
        this.userService.updateUser(UserDtoConverter.convertToDomain(userDto), userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<Void> delete(@PathVariable long userId){
        this.userService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
