package com.spring.data.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.spring.data.entity.Order;
public interface OrderRepository extends JpaRepository<Order, Long> {
}
