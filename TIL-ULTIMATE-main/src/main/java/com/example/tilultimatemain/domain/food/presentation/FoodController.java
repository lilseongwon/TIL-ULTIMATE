package com.example.tilultimatemain.domain.food.presentation;

import com.example.tilultimatemain.domain.food.presentation.request.FoodRequest;
import com.example.tilultimatemain.domain.food.service.AddFoodService;
import com.example.tilultimatemain.domain.food.service.DeleteFoodService;
import com.example.tilultimatemain.domain.food.service.UpdateFoodService;
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

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/")
    public void addFood(@RequestBody @Valid FoodRequest request) {
        addFoodService.execute(request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/{food-id}")
    public void execute(@PathVariable("food-id") Long id, @RequestBody @Valid FoodRequest foodRequest) {
        updateFoodService.execute(id, foodRequest);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{food-id}")
    public void execute(@PathVariable("food-id") Long id) {
        deleteFoodService.execute(id);
    }
}
