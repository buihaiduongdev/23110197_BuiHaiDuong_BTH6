package com.bth06.service;

import java.util.List;
import java.util.Optional;

import com.bth06.entity.User;

public interface UserService {
    List<User> findAll();
    User save(User entity);
    void deleteById(int id);
    List<User> search(String keyword);
    User findById(int id);
    Optional<User> login(String username, String password);
}
