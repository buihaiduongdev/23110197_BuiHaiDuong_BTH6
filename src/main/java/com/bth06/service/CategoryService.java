package com.bth06.service;

import java.util.List;

import com.bth06.entity.Category;

public interface CategoryService {
    List<Category> findAll();
    Category save(Category entity);
    void deleteById(int id);
    List<Category> search(String keyword);
    Category findById(int id);
}
