package com.example.tilultimatemain.domain.food.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@AllArgsConstructor
public enum Category {
    PASTA("파스타", "s3://til-ultimate/pasta.jpg"),
    SALAD("샐러드", "s3://til-ultimate/rice.jpg"),
    RICE("볶음밥", "s3://til-ultimate/salad.jpg");

    private final String name;
    private final String picture;
}
