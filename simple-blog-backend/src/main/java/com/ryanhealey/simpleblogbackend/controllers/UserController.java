package com.ryanhealey.simpleblogbackend.controllers;

import com.ryanhealey.simpleblogbackend.dto.UserDto;
import com.ryanhealey.simpleblogbackend.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(
        value = "/users",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE
)
public class UserController extends BlogController<UserDto, UserService>{
    public UserController(UserService service) {
        super(service);
    }
}
