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

    @Column(length = 50, nullable = false)
    private String address;

    @Column(length = 10, nullable = false)
    private String name;

    @Builder
    public User(String email, String password, String address, String name) {
        this.email = email;
        this.password = password;
        this.address = address;
        this.name = name;
    }

    public void updatePw(String password) {
        this.password = password;
    }

    public void updateInfo(String address, String name) {
        this.address = address;
        this.name = name;
    }
}
