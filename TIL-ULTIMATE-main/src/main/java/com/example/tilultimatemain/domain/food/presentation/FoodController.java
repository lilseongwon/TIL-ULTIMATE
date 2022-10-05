package com.example.tilultimatemain.domain.food.presentation;

import com.example.tilultimatemain.domain.food.presentation.request.FoodRequest;
import com.example.tilultimatemain.domain.food.service.AddFoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class FoodController {
    private final AddFoodService addFoodService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/")
    public void addFood(@RequestBody FoodRequest request) {
        addFoodService.execute(request);
    }
}
