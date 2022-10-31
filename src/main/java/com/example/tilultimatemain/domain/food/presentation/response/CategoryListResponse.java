package com.example.tilultimatemain.domain.food.presentation.response;

import com.example.tilultimatemain.domain.food.domain.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class CategoryListResponse {
    private final List<Category> categoryList;
}
