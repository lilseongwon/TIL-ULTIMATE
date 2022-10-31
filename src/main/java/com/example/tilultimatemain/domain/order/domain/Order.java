package com.example.tilultimatemain.domain.order.domain;

import com.example.tilultimatemain.domain.food.domain.Food;
import com.example.tilultimatemain.domain.user.domain.User;
import com.example.tilultimatemain.global.entity.BaseTimeEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "orders")
public class Order extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_id", nullable = false)
    private Food food;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private Integer sum;

    @Column(nullable = false)
    private Integer price;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Builder
    public Order(Food food, User user, Integer sum, Integer price) {
        this.food = food;
        this.user = user;
        this.status = Status.COOK;
        this.sum = sum;
        this.price = price;
    }

    public void completeCook() {
        this.status = Status.COMPLETE;
    }
}
