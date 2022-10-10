package com.example.tilultimatemain.domain.order.domain.repository;

import com.example.tilultimatemain.domain.order.domain.Order;
import com.example.tilultimatemain.domain.order.domain.Status;
import com.example.tilultimatemain.domain.user.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;


public interface OrderRepository extends CrudRepository<Order, Long> {
    List<Order> findAllByCreatedAtAndStatus(LocalDate createdAt, Status status);
    List<Order> findAllByUserId(User user);
}
