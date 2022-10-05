package com.example.tilultimatemain.domain.food.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String name;

    private Category category;

    @Column(nullable = false)
    private Integer stock;

    private String explain;

    private String picture;

    @Builder
    public Food(String name, Category category, Integer stock, String explain, String picture) {
        this.name = name;
        this.category = category;
        this.stock = stock;
        this.explain = explain;
        this.picture = picture;
    }

    public void updateFood(String name, Category category, Integer stock, String explain, String picture) {
        this.name = name;
        this.category = category;
        this.stock = stock;
        this.explain = explain;
        this.picture = picture;
    }
}
