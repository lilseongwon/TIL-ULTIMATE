package com.example.tilultimatemain.domain.food.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@JsonFormat(shape = JsonFormat.Shape.STRING)
@AllArgsConstructor
public enum Category {
    PASTA,
    SALAD,
    RICE
}
