package com.bth06.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bth06.entity.Video;

@Repository
public interface VideoRepository extends JpaRepository<Video, Integer> {
    List<Video> findByTitleContaining(String keyword);
}

