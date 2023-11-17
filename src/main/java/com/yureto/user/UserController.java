package com.yureto.user;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/users/{id}")
    public User getUser(@PathVariable("id") int id) {
        return userService.findUser(id);
    }

    @ControllerAdvice
    public class GlobalExceptionHandler {
        @ExceptionHandler(UserNotFoundException.class)
        @ResponseStatus(HttpStatus.NOT_FOUND)
        public ResponseEntity<Map<String, String>> handleUserNotFoundException(
                UserNotFoundException e, HttpServletRequest request) {
            Map<String, String> body = new HashMap<>();
            body.put("timestamp", ZonedDateTime.now().toString());
            body.put("status", String.valueOf(HttpStatus.NOT_FOUND.value()));
            body.put("error", HttpStatus.NOT_FOUND.getReasonPhrase());
            body.put("message", e.getMessage());
            body.put("path", request.getRequestURI());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
        }
    }
}



