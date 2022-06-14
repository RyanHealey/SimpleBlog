package com.ryanhealey.simpleblogbackend.controllers;

import com.ryanhealey.simpleblogbackend.dto.CurrentUserDto;
import com.ryanhealey.simpleblogbackend.service.CurrentUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(
        value = "/current",
        produces = MediaType.APPLICATION_JSON_VALUE
)
@AllArgsConstructor
public class CurrentUserController {

    private final CurrentUserService currentUserService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public CurrentUserDto getCurrentUser() {
        return currentUserService.getCurrentUserDto();

    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value="/{id}")
    public CurrentUserDto changeCurrentUser(@PathVariable UUID id) {
        return currentUserService.updateCurrentUserDto(id);
    }

}
