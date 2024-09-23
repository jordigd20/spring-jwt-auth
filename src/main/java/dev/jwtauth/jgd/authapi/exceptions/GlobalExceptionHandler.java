package dev.jwtauth.jgd.authapi.exceptions;

import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ProblemDetail handleSecurityException(Exception exc) {
        ProblemDetail errorDetail = null;

        exc.printStackTrace();

        return errorDetail;
    }
}
