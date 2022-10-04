package com.example.tilultimatemain.domain.user.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false)
    private String email;

    @Column(length = 20, nullable = false)
    private String password;

    @Column(length = 10, nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer money;

    @Builder
    public User(String email, String password, String name, Integer money) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.money = money;
    }

    public void updatePw(String password) {
        this.password = password;
    }

    public void updateInfo(String name) {
        this.name = name;
    }

    public void addMoney() {
        this.money = 15000;
    }

    public void subMoney() {
        this.money = 0;
    }
}
