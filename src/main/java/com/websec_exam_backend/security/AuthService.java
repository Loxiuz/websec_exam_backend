package com.websec_exam_backend.security;

import com.websec_exam_backend.dto.AuthorizationDTO;
import com.websec_exam_backend.dto.LoginDTO;
import com.websec_exam_backend.model.Permission;
import com.websec_exam_backend.model.User;
import com.websec_exam_backend.repository.RoleRepository;
import com.websec_exam_backend.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;

@Slf4j
@Service
public class AuthService {

    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private JwtTokenProvider jwtTokenProvider;
    private JwtAuthenticationFilter  jwtAuthenticationFilter;


    public AuthService(
            JwtTokenProvider jwtTokenProvider,
            UserRepository userRepository,
            RoleRepository roleRepository,
            AuthenticationManager authenticationManager,
            JwtAuthenticationFilter jwtAuthenticationFilter) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
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
        jwtAuthResponse.setRole(user.getRole().getRoleName());
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

    public AuthorizationDTO getCurrentUserPermissions(HttpServletRequest request) {
        String token = jwtAuthenticationFilter.getTokenFromRequest(request);

        if (token == null || !jwtTokenProvider.validateToken(token)) {
            request.setAttribute("error", "Invalid Token");
        }

        String username = jwtTokenProvider.getUsername(token);
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        Set<Permission> permissions = roleRepository.findPermissionsByRoleId(user.getRole().getId());
        if(permissions.isEmpty()) {
            throw new UsernameNotFoundException("No permissions found for role " + user.getRole().getRoleName());
        }

        return new AuthorizationDTO(user.getRole().getRoleName(), permissions.stream().map(Permission::getPermissionName).toList());
    }
}
