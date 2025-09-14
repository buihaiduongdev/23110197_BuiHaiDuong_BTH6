package com.bth06.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bth06.entity.User;
import com.bth06.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repo;

    @Override
    public List<User> findAll() {
        return repo.findAll();
    }

    @Override
    public User save(User entity) {
        return repo.save(entity);
    }

    @Override
    public void deleteById(int id) {
        repo.deleteById(id);
    }

    @Override
    public List<User> search(String keyword) {
        return repo.findByUsernameContaining(keyword);
    }

    @Override
    public User findById(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Optional<User> login(String username, String password) {
        return repo.findByUsernameAndPassword(username, password);
    }
}
