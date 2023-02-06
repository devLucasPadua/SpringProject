package com.example.springproject.config;

import com.example.springproject.entities.User;
import com.example.springproject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) {
        try {
            User u1 = new User(null, "Maria Clara", "claramaria@gmail.com", "16999998888", "12345678");
            User u2 = new User(null, "João Carlos", "carlosjoao@gmail.com", "19888889999", "87654321");

            userRepository.saveAll(Arrays.asList(u1, u2));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
