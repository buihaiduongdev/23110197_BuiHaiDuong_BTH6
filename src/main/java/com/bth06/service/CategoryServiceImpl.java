package com.bth06.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bth06.entity.Category;
import com.bth06.repository.CategoryRepository;
import com.bth06.repository.VideoRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	private final VideoRepository videoRepository;

	@Autowired
	private CategoryRepository repo;

	CategoryServiceImpl(VideoRepository videoRepository) {
		this.videoRepository = videoRepository;
	}

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

	public boolean hasVideos(int categoryId) {
		return videoRepository.existsById(categoryId);
	}

}
