package com.bth06.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bth06.entity.Video;
import com.bth06.repository.VideoRepository;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoRepository repo;

    @Override
    public List<Video> findAll() {
        return repo.findAll();
    }

    @Override
    public Video save(Video entity) {
        return repo.save(entity);
    }

    @Override
    public void deleteById(int id) {
        repo.deleteById(id);
    }

    @Override
    public List<Video> search(String keyword) {
        return repo.findByTitleContaining(keyword);
    }

    @Override
    public Video findById(int id) {
        return repo.findById(id).orElse(null);
    }
}
