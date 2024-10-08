package dev.jwtauth.jgd.authapi.users;

import dev.jwtauth.jgd.authapi.users.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);
}
