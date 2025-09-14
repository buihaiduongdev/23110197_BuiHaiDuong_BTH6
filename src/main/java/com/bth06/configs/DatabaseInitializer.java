package com.bth06.configs;

import com.bth06.entity.Category;
import com.bth06.entity.User;
import com.bth06.repository.CategoryRepository;
import com.bth06.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer implements CommandLineRunner {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
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
    }
}
