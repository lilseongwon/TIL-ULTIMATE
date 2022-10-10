package com.example.tilultimatemain.domain.food.domain;

import com.example.tilultimatemain.domain.order.domain.Order;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "food")
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String name;

    private Category category;

    private String explain;

    private String picture;

    private Integer price;

    @OneToMany(mappedBy = "food", cascade = CascadeType.REMOVE)
    private List<Order> orderList;

    @Builder
    public Food(String name, Category category, String explain, String picture, Integer price) {
        this.name = name;
        this.category = category;
        this.explain = explain;
        this.picture = picture;
        this.price = price;
    }

    public void updateFood(String name, Category category, String explain, String picture, Integer price) {
        this.name = name;
        this.category = category;
        this.explain = explain;
        this.picture = picture;
        this.price = price;
    }
}
