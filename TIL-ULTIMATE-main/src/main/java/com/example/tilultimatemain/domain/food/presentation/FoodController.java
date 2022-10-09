package com.example.tilultimatemain.domain.food.presentation;

import com.example.tilultimatemain.domain.food.domain.Category;
import com.example.tilultimatemain.domain.food.presentation.request.FoodRequest;
import com.example.tilultimatemain.domain.food.presentation.response.CategoryListResponse;
import com.example.tilultimatemain.domain.food.presentation.response.QueryFoodInfoResponse;
import com.example.tilultimatemain.domain.food.presentation.response.QueryFoodListResponse;
import com.example.tilultimatemain.domain.food.presentation.response.QueryFoodResponse;
import com.example.tilultimatemain.domain.food.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/food")
public class FoodController {
    private final AddFoodService addFoodService;
    private final UpdateFoodService updateFoodService;
    private final DeleteFoodService deleteFoodService;
    private final QueryCategoryListService queryCategoryListService;
    private final QueryFoodsByKeywordService queryFoodsByKeywordService;
    private final QueryFoodsByCategoryService queryFoodsByCategoryService;
    private final QueryFoodListService queryFoodListService;
    private final QueryFoodInfoService queryFoodInfoService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/")
    public void addFood(@RequestBody @Valid FoodRequest request) {
        addFoodService.execute(request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/{food-id}")
    public void updateFood(@PathVariable("food-id") Long id, @RequestBody @Valid FoodRequest foodRequest) {
        updateFoodService.execute(id, foodRequest);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{food-id}")
    public void deleteFood(@PathVariable("food-id") Long id) {
        deleteFoodService.execute(id);
    }

    @GetMapping("/tags")
    public CategoryListResponse queryCategory() {
        return queryCategoryListService.execute();
    }

    @GetMapping("/title")
    public QueryFoodListResponse queryFoodByKeyword(@RequestParam(value = "keyword")String keyword) {
        return queryFoodsByKeywordService.execute(keyword);
    }

    @GetMapping("/tag")
    public QueryFoodListResponse queryFoodByTag(@RequestParam(value = "category")Category category) {
        return queryFoodsByCategoryService.execute(category);
    }

    @GetMapping("/")
    public QueryFoodListResponse queryFoodList() {
        return queryFoodListService.execute();
    }

    @GetMapping("/{food-id}")
    public QueryFoodInfoResponse queryFoodInfo(@PathVariable("food-id")Long id) {
        return queryFoodInfoService.execute(id);
    }
}
