package com.websec_exam_backend.security;

import com.websec_exam_backend.user_login.LoginDTO;

public interface AuthService {
    String login(LoginDTO loginDto);
}
