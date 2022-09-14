package com.example.tilultimatemain.domain.user.domain;

import com.example.tilultimatemain.domain.user.Sex;
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
    private String accountId;

    @Column(length = 20, nullable = false)
    private String password;

    @Column(length = 6, nullable = false)
    private Sex sex;

    @Builder
    public User(String accountId, String password, Sex sex) {
        this.accountId = accountId;
        this.password = password;
        this.sex = sex;
    }

    public void updatePw(String password) {
        this.password = password;
    }
}
