package dev.jwtauth.jgd.authapi.auth;

import dev.jwtauth.jgd.authapi.auth.dtos.AuthResponseDto;
import dev.jwtauth.jgd.authapi.auth.dtos.LoginRequestDto;
import dev.jwtauth.jgd.authapi.auth.dtos.RegisterRequestDto;
import dev.jwtauth.jgd.authapi.auth.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> login(@RequestBody LoginRequestDto body) {
        return ResponseEntity.ok(authService.login(body));
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponseDto> register(@RequestBody RegisterRequestDto body) {
        return ResponseEntity.ok(authService.register(body));
    }

}
