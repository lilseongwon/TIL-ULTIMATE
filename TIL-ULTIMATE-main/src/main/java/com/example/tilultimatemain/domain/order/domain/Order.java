package com.example.tilultimatemain.domain.order.domain;

import com.example.tilultimatemain.domain.food.domain.Food;
import com.example.tilultimatemain.domain.user.domain.User;
import com.example.tilultimatemain.global.entity.BaseTimeEntity;
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
    @JoinColumn(name = "food", nullable = false)
    private Food foodId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user", nullable = false)
    private User userId;

    @Column(nullable = false)
    private Integer sum;

    @Column(nullable = false)
    private Integer price;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Builder
    public Order(Food foodId, User userId, Integer sum, Integer price) {
        this.foodId = foodId;
        this.userId = userId;
        this.status = Status.COOK;
        this.sum = sum;
        this.price = price;
    }

    public void completeCook() {
        this.status = Status.COMPLETE;
    }
}
