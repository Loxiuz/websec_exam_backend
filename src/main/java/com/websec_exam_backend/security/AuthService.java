package com.websec_exam_backend.security;

import com.websec_exam_backend.user_login.LoginDTO;
import com.websec_exam_backend.user_login.User;
import com.websec_exam_backend.user_login.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AuthService {

    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    private JwtTokenProvider jwtTokenProvider;
    private JwtAuthenticationFilter  jwtAuthenticationFilter;


    public AuthService(
            JwtTokenProvider jwtTokenProvider,
            UserRepository userRepository,
            AuthenticationManager authenticationManager,
            JwtAuthenticationFilter jwtAuthenticationFilter) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.jwtTokenProvider = jwtTokenProvider;
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }

    public JwtAuthResponse login(LoginDTO loginDto) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsername(), loginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtTokenProvider.generateToken(authentication);

        JwtAuthResponse jwtAuthResponse = new JwtAuthResponse();
        jwtAuthResponse.setAccessToken(jwt);
        User user = userRepository.findByUsername(jwtTokenProvider.getUsername(jwt))
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        jwtAuthResponse.setEmployeeId(user.getEmployee().getId().toString());
        jwtAuthResponse.setRole(user.getRoles().iterator().next().getName());
        jwtAuthResponse.setUsername(user.getUsername());

        return jwtAuthResponse;
    }

    public boolean isLoggedIn(HttpServletRequest request) {
        String token = jwtAuthenticationFilter.getTokenFromRequest(request);

        if (token == null || !jwtTokenProvider.validateToken(token)) {
            return false;
        }
        return userRepository.findByUsername(jwtTokenProvider.getUsername(token)).isPresent();
    }
}
