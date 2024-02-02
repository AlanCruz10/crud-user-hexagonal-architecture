package com.user.app.application.services;

import com.user.app.application.ports.inputs.IUserServicePortInput;
import com.user.app.application.ports.outputs.IUserServicePortOutput;
import com.user.app.domain.exceptions.UserNotFoundException;
import com.user.app.domain.models.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class UserService implements IUserServicePortInput {

    private IUserServicePortOutput userServicePortOutput;

    @Override
    public User findById(Long id) {
        return userServicePortOutput.findById(id).orElseThrow(UserNotFoundException::new);
    }

    @Override
    public User save(User user) {
        return userServicePortOutput.save(user);
    }

    @Override
    public User update(Long id, User user) {
        return userServicePortOutput.findById(id).map(userFound -> {
            userFound.setFirstName(user.getFirstName());
            userFound.setLastName(user.getLastName());
            userFound.setEmail(user.getEmail());
            userFound.setPassword(user.getPassword());
            return userFound;
        }).orElseThrow(UserNotFoundException::new);
    }

    @Override
    public List<User> findAll() {
        return userServicePortOutput.findAll();
    }

    @Override
    public void deleteById(Long id) {
        if (userServicePortOutput.findById(id).isPresent()) {
            throw new UserNotFoundException();
        }
        userServicePortOutput.deleteById(id);
    }

}