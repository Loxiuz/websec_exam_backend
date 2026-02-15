package com.websec_exam_backend.security;

import com.websec_exam_backend.user_login.LoginDTO;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<HashMap<String, String>> authenticate(@RequestBody LoginDTO loginDto, HttpServletResponse response) {
        JwtAuthResponse jwtAuthResponse = authService.login(loginDto);

        Cookie accessToken = new Cookie("accessToken", jwtAuthResponse.getAccessToken());
        accessToken.setHttpOnly(true);
        accessToken.setSecure(true);
        accessToken.setPath("/");
        accessToken.setMaxAge(60 * 60);

        response.addCookie(accessToken);

        HashMap<String, String> authResponse = new HashMap<>();
        authResponse.put("employeeId", String.valueOf(jwtAuthResponse.getEmployeeId()));
        authResponse.put("role", jwtAuthResponse.getRole());
        authResponse.put("username", jwtAuthResponse.getUsername());

        return ResponseEntity.ok().body(authResponse);

    }

    @PostMapping("/logout")
    public ResponseEntity<Map<String, String>> logout(HttpServletResponse response) {
        Cookie accessToken = new Cookie("accessToken", null);
        accessToken.setHttpOnly(true);
        accessToken.setSecure(true);
        accessToken.setPath("/");
        accessToken.setMaxAge(0);

        response.addCookie(accessToken);

        Map<String, String> logoutResponse = new HashMap<>();
        logoutResponse.put("message", "Logged out successfully");

        return ResponseEntity.ok(logoutResponse);
    }

    @GetMapping("/logged-in")
    public ResponseEntity<Map<String, Boolean>> isLoggedIn(HttpServletRequest request) {
        boolean loggedIn = authService.isLoggedIn(request);

        Map<String, Boolean> response = new HashMap<>();
        response.put("loggedIn", loggedIn);

        return ResponseEntity.ok(response);

    }

}
