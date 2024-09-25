package dev.jwtauth.jgd.authapi.auth.dtos;

public class AuthResponseDto {

    public AuthResponseDto() {
    }

    public AuthResponseDto(String token) {
        this.token = token;
    }

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "AuthResponseDto{" +
                "token='" + token + '\'' +
                '}';
    }
}
