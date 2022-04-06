package com.kerich.thread.repository;

import org.springframework.stereotype.Repository;

import com.kerich.thread.entity.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    
}
