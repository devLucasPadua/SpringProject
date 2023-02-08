package com.example.springproject.config;

import com.example.springproject.entities.Category;
import com.example.springproject.entities.Order;
import com.example.springproject.entities.User;
import com.example.springproject.entities.enums.OrderStatus;
import com.example.springproject.repositories.CategoryRepository;
import com.example.springproject.repositories.OrderRepository;
import com.example.springproject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) {
        try {
            User u1 = new User(null, "Maria Clara", "claramaria@gmail.com", "16999998888", "12345678");
            User u2 = new User(null, "João Carlos", "carlosjoao@gmail.com", "19888889999", "87654321");

            Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.DELIVERED, u1);
            Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
            Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.CANCELED, u1);

            Category cat1 = new Category(null, "Electronics");
            Category cat2 = new Category(null, "Books");
            Category cat3 = new Category(null, "Computers");

            userRepository.saveAll(Arrays.asList(u1, u2));
            orderRepository.saveAll(Arrays.asList(o1, o2, o3));
            categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
