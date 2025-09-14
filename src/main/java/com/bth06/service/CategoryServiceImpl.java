package com.bth06.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bth06.entity.Category;
import com.bth06.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository repo;

    @Override
    public List<Category> findAll() {
        return repo.findAll();
    }

    @Override
    public Category save(Category entity) {
        return repo.save(entity);
    }

    @Override
    public void deleteById(int id) {
        repo.deleteById(id);
    }

    @Override
    public List<Category> search(String keyword) {
        return repo.findByCategoryNameContaining(keyword);
    }

    @Override
    public Category findById(int id) {
        return repo.findById(id).orElse(null);
    }
}
