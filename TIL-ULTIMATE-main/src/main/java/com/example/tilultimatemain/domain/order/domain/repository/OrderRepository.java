package com.example.tilultimatemain.domain.order.domain.repository;

import com.example.tilultimatemain.domain.order.domain.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
