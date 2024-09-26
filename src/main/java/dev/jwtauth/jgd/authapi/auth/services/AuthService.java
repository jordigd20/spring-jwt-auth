package dev.jwtauth.jgd.authapi.auth.services;

import dev.jwtauth.jgd.authapi.auth.dtos.AuthResponseDto;
import dev.jwtauth.jgd.authapi.auth.dtos.LoginRequestDto;
import dev.jwtauth.jgd.authapi.auth.dtos.RegisterRequestDto;
import dev.jwtauth.jgd.authapi.users.UserRepository;
import dev.jwtauth.jgd.authapi.users.UserRole;
import dev.jwtauth.jgd.authapi.users.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authManager;

    @Autowired
    public AuthService(UserRepository userRepository, JwtService jwtService, PasswordEncoder passwordEncoder, AuthenticationManager authManager) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
        this.authManager = authManager;
    }

    public AuthResponseDto login(LoginRequestDto body) {
        authManager.authenticate(new UsernamePasswordAuthenticationToken(body.getEmail(), body.getPassword()));

        UserDetails user = userRepository.findByEmail(body.getEmail()).orElseThrow();
        String token = jwtService.getToken(user);

        return new AuthResponseDto(token);
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
