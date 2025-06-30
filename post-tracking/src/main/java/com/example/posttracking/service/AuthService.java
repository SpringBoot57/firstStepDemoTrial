package com.example.posttracking.service;

import com.example.posttracking.dto.AuthResponse;
import com.example.posttracking.dto.LoginRequest;
import com.example.posttracking.dto.RegisterRequest;

public interface AuthService {
    AuthResponse login(LoginRequest request);
    void register(RegisterRequest request);
}
