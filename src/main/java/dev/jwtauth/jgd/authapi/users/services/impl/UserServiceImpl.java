package dev.jwtauth.jgd.authapi.users.services.impl;

import dev.jwtauth.jgd.authapi.users.entities.User;
import dev.jwtauth.jgd.authapi.users.UserRepository;
import dev.jwtauth.jgd.authapi.users.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findUserById(Integer id) {
        Optional<User> user = userRepository.findById(id);

        if (user.isEmpty()) {
            throw new RuntimeException(""); // TODO: NotFoundException
        }

        return user.get();
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    private void validateUser(User user) {

    }
}
