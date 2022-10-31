package com.example.tilultimatemain.domain.food.presentation.request;

import com.example.tilultimatemain.domain.food.domain.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class FoodRequest {

    @NotBlank(message = "food는 Null 또는 공백 또는 띄어쓰기를 허용하지 않습니다.")
    @Size(min = 1, max = 50, message = "name은 최대 50자 입니다.")
    private String name;

    private Category category;

    @Size(min = 1, max= 500, message = "explain은 최대 500자 입니다.")
    private String explain;

    private String picture;

    @NotNull(message = "price는 Null을 허용하지 않습니다.")
    private Integer price;
}
