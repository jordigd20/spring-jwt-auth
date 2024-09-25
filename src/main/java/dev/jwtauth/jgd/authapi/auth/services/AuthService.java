package dev.jwtauth.jgd.authapi.auth.services;

import dev.jwtauth.jgd.authapi.auth.dtos.AuthResponseDto;
import dev.jwtauth.jgd.authapi.auth.dtos.LoginRequestDto;
import dev.jwtauth.jgd.authapi.auth.dtos.RegisterRequestDto;
import dev.jwtauth.jgd.authapi.users.UserRepository;
import dev.jwtauth.jgd.authapi.users.UserRole;
import dev.jwtauth.jgd.authapi.users.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;

    @Autowired
    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public AuthResponseDto login(LoginRequestDto body) {
        return null;
    }

    public AuthResponseDto register(RegisterRequestDto body) {
        User user = new User();
        user.setEmail(body.getEmail());
        user.setFullName(body.getFullName());
        user.setPassword(body.getPassword());
        user.setRole(UserRole.USER);

        userRepository.save(user);

        return new AuthResponseDto("User registered successfully");
    }
}
