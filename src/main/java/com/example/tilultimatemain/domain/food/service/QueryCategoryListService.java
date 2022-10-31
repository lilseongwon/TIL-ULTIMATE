package com.example.tilultimatemain.domain.food.service;

import com.example.tilultimatemain.domain.food.domain.Category;
import com.example.tilultimatemain.domain.food.presentation.response.CategoryListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class QueryCategoryListService {

    @Transactional
    public CategoryListResponse execute() {
        return new CategoryListResponse(
                Arrays
                        .stream(Category.class.getEnumConstants())
                        .collect(Collectors.toList())
        );
    }
}