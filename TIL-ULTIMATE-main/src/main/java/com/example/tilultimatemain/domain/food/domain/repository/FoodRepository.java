package com.example.tilultimatemain.domain.food.domain.repository;

import com.example.tilultimatemain.domain.food.domain.Food;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface FoodRepository extends CrudRepository<Food, Long> {
    Optional<Food> findByName(String name);
}
