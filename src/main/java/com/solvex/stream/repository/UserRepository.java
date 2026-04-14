package com.solvex.stream.repository;

//UserRepository.java
import org.springframework.data.jpa.repository.JpaRepository;

import com.solvex.stream.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
 Optional<User> findByUserName(String userName);
}
