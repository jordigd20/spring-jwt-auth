package dev.jwtauth.jgd.authapi.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/demo")
    public String welcome() {
        return "Welcome to the Auth API!";
    }
}
