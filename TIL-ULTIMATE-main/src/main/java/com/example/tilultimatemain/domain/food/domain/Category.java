package com.example.tilultimatemain.domain.food.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@AllArgsConstructor
public enum Category {
    PASTA("파스타", "https://til-ultimate.s3.ap-northeast-2.amazonaws.com/pasta.jpg"),
    SALAD("샐러드", "https://til-ultimate.s3.ap-northeast-2.amazonaws.com/rice.jpg"),
    RICE("볶음밥", "https://til-ultimate.s3.ap-northeast-2.amazonaws.com/salad.jpg");

    private final String name;
    private final String picture;
}
