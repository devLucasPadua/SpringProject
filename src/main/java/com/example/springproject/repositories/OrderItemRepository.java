package com.example.springproject.repositories;

import com.example.springproject.entities.Category;
import com.example.springproject.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
