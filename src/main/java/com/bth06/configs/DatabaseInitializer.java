package com.bth06.configs;

import com.bth06.entity.Category;
import com.bth06.entity.User;
import com.bth06.entity.Video;
import com.bth06.repository.CategoryRepository;
import com.bth06.repository.UserRepository;
import com.bth06.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer implements CommandLineRunner {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VideoRepository videoRepository;

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.count() == 0) {
            // Create categories
            Category category1 = new Category();
            category1.setCategoryName("Action");
            category1.setImages("action.jpg");
            categoryRepository.save(category1);

            Category category2 = new Category();
            category2.setCategoryName("Comedy");
            category2.setImages("comedy.jpg");
            categoryRepository.save(category2);

            // Create users
            User admin = new User();
            admin.setUsername("admin");
            admin.setPassword("admin"); // In a real application, you should hash the password
            admin.setFullName("Admin");
            admin.setEmail("admin@example.com");
            admin.setRole("ADMIN");
            userRepository.save(admin);

            User user = new User();
            user.setUsername("user");
            user.setPassword("user"); // In a real application, you should hash the password
            user.setFullName("User");
            user.setEmail("user@example.com");
            user.setRole("USER");
            userRepository.save(user);

            // Create videos
            Video video1 = new Video();
            video1.setTitle("Action Movie 1");
            video1.setDescription("An exciting action movie.");
            video1.setUrl("https://www.youtube.com/watch?v=action1");
            video1.setCategory(category1);
            videoRepository.save(video1);

            Video video2 = new Video();
            video2.setTitle("Comedy Movie 1");
            video2.setDescription("A hilarious comedy.");
            video2.setUrl("https://www.youtube.com/watch?v=comedy1");
            video2.setCategory(category2);
            videoRepository.save(video2);
        }
    }
}
