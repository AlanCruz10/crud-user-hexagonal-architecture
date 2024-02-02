package com.user.app.application.ports.outputs;

import com.user.app.domain.models.User;

import java.util.List;
import java.util.Optional;

public interface IUserServicePortOutput {

    Optional<User> findById(Long id);
    List<User> findAll();
    User save(User student);
    void deleteById(Long id);

}