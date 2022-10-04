package com.example.tilultimatemain.domain.order.domain.repository;

import com.example.tilultimatemain.domain.order.domain.Food;
import org.springframework.data.repository.CrudRepository;

public interface FoodRepository extends CrudRepository<Food, Long> {
    
}
