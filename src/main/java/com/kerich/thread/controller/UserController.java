package com.kerich.thread.controller;

import java.util.concurrent.CompletableFuture;

import com.kerich.thread.entity.UserEntity;
import com.kerich.thread.service.UserService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/")
    void addUser(@RequestBody UserEntity model){
        CompletableFuture<UserEntity> comp=CompletableFuture.completedFuture(model);
    }
    
}
