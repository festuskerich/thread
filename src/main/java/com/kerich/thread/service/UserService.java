package com.kerich.thread.service;

import java.util.concurrent.CompletableFuture;

import com.kerich.thread.entity.UserEntity;
import com.kerich.thread.repository.UserRepository;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    final UserRepository userRepository;

    @Async
    public CompletableFuture<UserEntity> saveUser(UserEntity userEntity) {
        UserEntity userEntity2 = userRepository.save(userEntity);
        return CompletableFuture.completedFuture(userEntity2);
    }
}
