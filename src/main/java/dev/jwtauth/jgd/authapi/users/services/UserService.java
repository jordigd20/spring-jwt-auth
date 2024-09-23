package dev.jwtauth.jgd.authapi.users.services;

import dev.jwtauth.jgd.authapi.users.entities.User;

import java.util.List;

public interface UserService {
    User findUserById(Integer id);

    List<User> findAllUsers();
}
