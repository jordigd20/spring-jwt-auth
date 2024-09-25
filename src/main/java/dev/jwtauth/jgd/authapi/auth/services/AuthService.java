package dev.jwtauth.jgd.authapi.auth.services;

import dev.jwtauth.jgd.authapi.auth.dtos.AuthResponseDto;
import dev.jwtauth.jgd.authapi.auth.dtos.LoginRequestDto;
import dev.jwtauth.jgd.authapi.auth.dtos.RegisterRequestDto;
import dev.jwtauth.jgd.authapi.users.UserRepository;
import dev.jwtauth.jgd.authapi.users.UserRole;
import dev.jwtauth.jgd.authapi.users.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthService(UserRepository userRepository, JwtService jwtService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
    }

    public AuthResponseDto login(LoginRequestDto body) {
        return null;
    }

    public AuthResponseDto register(RegisterRequestDto body) {
        User user = new User();
        user.setEmail(body.getEmail());
        user.setFullName(body.getFullName());
        user.setPassword(passwordEncoder.encode(body.getPassword()));
        user.setRole(UserRole.USER);

        userRepository.save(user);

        return new AuthResponseDto(jwtService.getToken(user));
    }
}
