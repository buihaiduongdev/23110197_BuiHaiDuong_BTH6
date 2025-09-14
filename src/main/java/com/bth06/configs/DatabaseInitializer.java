package com.bth06.configs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.bth06.entity.Category;
import com.bth06.entity.User;
import com.bth06.entity.Video;
import com.bth06.repository.CategoryRepository;
import com.bth06.repository.UserRepository;
import com.bth06.repository.VideoRepository;

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
		if (categoryRepository.count() == 0) {
			Category category1 = new Category();
			category1.setCategoryName("Action");
			category1.setImages("action.jpg");
			categoryRepository.save(category1);

			Category category2 = new Category();
			category2.setCategoryName("Comedy");
			category2.setImages("comedy.jpg");
			categoryRepository.save(category2);
		}

		if (userRepository.count() == 0) {
			User admin = new User();
			admin.setUsername("admin");
			admin.setPassword("admin");
			admin.setFullName("Admin");
			admin.setEmail("admin@example.com");
			admin.setRole("ADMIN");
			userRepository.save(admin);

			User user = new User();
			user.setUsername("user");
			user.setPassword("user");
			user.setFullName("User");
			user.setEmail("user@example.com");
			user.setRole("USER");
			userRepository.save(user);
		}

		if (videoRepository.count() == 0) {
			List<Category> categories = categoryRepository.findAll();
			Category actionCategory = categories.stream().filter(c -> c.getCategoryName().equals("Action")).findFirst()
					.orElse(null);
			Category comedyCategory = categories.stream().filter(c -> c.getCategoryName().equals("Comedy")).findFirst()
					.orElse(null);

			if (actionCategory != null) {
				Video video1 = new Video();
				video1.setTitle("Action Movie 1");
				video1.setDescription("An exciting action movie.");
				video1.setUrl("https://www.youtube.com/watch?v=action1");
				video1.setCategory(actionCategory);
				videoRepository.save(video1);
			}

			if (comedyCategory != null) {
				Video video2 = new Video();
				video2.setTitle("Comedy Movie 1");
				video2.setDescription("A hilarious comedy.");
				video2.setUrl("https://www.youtube.com/watch?v=comedy1");
				video2.setCategory(comedyCategory);
				videoRepository.save(video2);
			}
		}
	}
}
