package com.websec_exam_backend.controller;

import com.websec_exam_backend.dto.LoginDTO;
import com.websec_exam_backend.dto.AuthorizationDTO;
import com.websec_exam_backend.security.AuthService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<Void> authenticate(@Valid @RequestBody LoginDTO loginDto, HttpServletResponse response) {
        String token = authService.login(loginDto);

        Cookie accessToken = new Cookie("accessToken",  token);
        accessToken.setHttpOnly(true);
        accessToken.setSecure(true);
        accessToken.setPath("/");
        accessToken.setMaxAge(60 * 60);

        response.addCookie(accessToken);

        return ResponseEntity.ok().build();

    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody LoginDTO loginDto) {
        if(!authService.register(loginDto)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error registering user");
        }
        return ResponseEntity.ok("Registration successful");
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpServletResponse response) {
        //TODO: Possibly implement Redis to revoke access token
        Cookie accessToken = new Cookie("accessToken", null);
        accessToken.setHttpOnly(true);
        accessToken.setSecure(true);
        accessToken.setPath("/");
        accessToken.setMaxAge(0);

        response.addCookie(accessToken);

        return ResponseEntity.ok("Logout successful");
    }

    @GetMapping("/logged-in")
    public ResponseEntity<Map<String, Boolean>> isLoggedIn(HttpServletRequest request) {
        boolean loggedIn = authService.isLoggedIn(request);

        Map<String, Boolean> response = new HashMap<>();
        response.put("loggedIn", loggedIn);

        return ResponseEntity.ok(response);

    }

    @GetMapping("/me/permissions")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER', 'GUEST')")
    public ResponseEntity<AuthorizationDTO> getCurrentUserPermissions(HttpServletRequest request) {
        AuthorizationDTO authorizationDTO = authService.getCurrentUserPermissions(request);
        if(authorizationDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(authorizationDTO);
    }

}
