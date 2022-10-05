package com.example.tilultimatemain.domain.food.service;

import com.example.tilultimatemain.domain.food.domain.Food;
import com.example.tilultimatemain.domain.food.facade.FoodFacade;
import com.example.tilultimatemain.domain.food.domain.repository.FoodRepository;
import com.example.tilultimatemain.domain.food.presentation.request.FoodRequest;
import com.example.tilultimatemain.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class AddFoodService {
    private final FoodRepository foodRepository;
    private final UserFacade userFacade;
    private final FoodFacade foodFacade;

    @Transactional
    public void execute(FoodRequest request) {
        userFacade.checkPermission();
        foodFacade.checkFoodExist(request.getName());

        foodRepository.save(
                Food.builder()
                        .name(request.getName())
                        .category(request.getCategory())
                        .explain(request.getExplain())
                        .picture(request.getPicture())
                        .build());
    }
}
