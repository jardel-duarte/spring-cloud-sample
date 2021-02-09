package com.atlantico.desafio.persistence.service;


import com.atlantico.desafio.persistence.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserService extends CrudRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
