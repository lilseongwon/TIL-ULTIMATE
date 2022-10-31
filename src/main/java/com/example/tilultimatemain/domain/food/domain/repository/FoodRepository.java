package com.example.tilultimatemain.domain.food.domain.repository;

import com.example.tilultimatemain.domain.food.domain.Category;
import com.example.tilultimatemain.domain.food.domain.Food;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface FoodRepository extends CrudRepository<Food, Long> {
    Optional<Food> findByName(String name);
    List<Food> findAllByOrderByIdDesc();

    List<Food> findAllByCategory(Category category);

    List<Food> findAllByNameContains(String keyword);
}
