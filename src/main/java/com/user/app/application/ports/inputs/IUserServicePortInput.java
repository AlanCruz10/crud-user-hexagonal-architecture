package com.user.app.application.ports.inputs;

import com.user.app.domain.models.User;

import java.util.List;

public interface IUserServicePortInput {

    User findById(Long id);
    User save(User user);
    User update(Long id, User user);
    List<User> findAll();
    void deleteById(Long id);

}