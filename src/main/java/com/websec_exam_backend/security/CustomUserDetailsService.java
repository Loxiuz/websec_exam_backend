package com.websec_exam_backend.security;

import com.websec_exam_backend.model.User;
import com.websec_exam_backend.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println("loadUserByUsername: " + username);
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username does not exist"));

        Set<GrantedAuthority> authorities = user.getRole().getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermissionName()))
                .collect(Collectors.toSet());

        authorities.add(new SimpleGrantedAuthority(user.getRole().getRoleName()));

        return new org.springframework.security.core.userdetails.User(
                username,
                user.getPassword(),
                authorities
        );
    }
}
