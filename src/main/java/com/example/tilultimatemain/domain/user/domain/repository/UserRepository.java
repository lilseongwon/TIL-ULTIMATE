package com.example.tilultimatemain.domain.user.domain.repository;

import com.example.tilultimatemain.domain.user.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
