package com.bth06.service;

import java.util.List;

import com.bth06.entity.Video;

public interface VideoService {
    List<Video> findAll();
    Video save(Video entity);
    void deleteById(int id);
    List<Video> search(String keyword);
    Video findById(int id);
}
