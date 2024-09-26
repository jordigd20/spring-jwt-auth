package dev.jwtauth.jgd.authapi.users;

import dev.jwtauth.jgd.authapi.users.entities.User;
import dev.jwtauth.jgd.authapi.users.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(userService.findAllUsers());
    }

    @GetMapping("/me")
    public ResponseEntity<User> getMe() {
        return ResponseEntity.ok(new User());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        return ResponseEntity.ok(userService.findUserById(id));
    }

    @PostMapping
    public ResponseEntity createUser(@RequestBody User user) {
        return ResponseEntity.ok("User created");
    }
}
