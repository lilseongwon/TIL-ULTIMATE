package com.example.tilultimatemain.domain.order.domain.repository;

import com.example.tilultimatemain.domain.order.domain.Order;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;


public interface OrderRepository extends CrudRepository<Order, Long> {
    List<Order> findAllByCreatedAt(LocalDate createdAt);
}
